package com.luxsoft.datastructure.list;

import java.util.StringJoiner;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public void add(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        array[size] = value;
        size++;
    }

    @Override
    //[A, B, C] 3
    public void add(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if(index > size){
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }
        // new 3 == 10 = false
        if(size == array.length){
            Object[] resizedArray = new Object[(int)(array.length * 1.5)];
            for (int i = 0; i < size; i++) {
                resizedArray[i] = array[i];
            }
            array = resizedArray;
            System.out.println(array.length);
        }

        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }

        this.set(value, index);
        size++;
    }

    @Override
    public Object remove(int index) {
       if ( index >= size ){
           throw new IndexOutOfBoundsException("Index out of bounds exception");
       }
       Object obj = get(index);
       System.arraycopy( array, index + 1, array, index, size - index -1 );
       array[size -1] =  null;
       size--;
       return  obj;
    }

    @Override
    public Object get(int index) {
        if(index > size  - 1){
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }

        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }
        if(index > size  - 1){
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }

        Object o = array[index];
        array[index] = value;
        return o;
    }

    @Override
    public void clear() {
        for ( int i = 0; i < array.length; i++){
            array[i] =  null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }
        for (int i = 0; i < size; i++) {
            Object valueInList = array[i];
            if (value.equals(valueInList)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++){
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }
}
