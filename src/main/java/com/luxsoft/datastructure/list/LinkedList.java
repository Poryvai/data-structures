package com.luxsoft.datastructure.list;

import com.sun.source.tree.WhileLoopTree;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List {

    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        add(value, size-1);
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size-1) { // доюавляем в конец
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) { //добавляем в начало
            head.prev = newNode;
            newNode.next = head;//устанавливаем связь
            head = newNode;
        }else{
            Node currentNode = getNode(index-1);
            currentNode.prev.next = newNode;
            newNode.prev = currentNode.prev;
            newNode.next = currentNode;
            currentNode.prev = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node current = head;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
            if (current == null) {
                return null;
            }
        }
        if (current == head){
            head = current.next;
        }else {
            current.prev.next = current.next;
        }

        if(current == tail){
            tail = current.prev;
        }else{
            current.next.prev = current.prev;
        }
        size--;
        return current;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node current = getNode(index);
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node current = head;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
            if (current == null) {
                return null;
            }
        }
        current.value = value;
     //getNode(index).value  = value;
        return current;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }
        for ( int i = 0; i < size; i++){
            if (get(i).equals(value)){
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
        for ( int i = size -1; i >= 0; i--){
            if (get(i).equals(value)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }

        return stringJoiner.toString();
    }

    private Node getNode(int index) {
        Node current;
        if (size / 2 <= index) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = 0; i < size - index - 1; i++) {
                current = current.prev;
            }
        }
        return current;
    }
}
