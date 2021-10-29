package com.luxsoft.datastructure.queue;

public class ArrayQueue implements Queue{
    int maxSize;
    int front;
    int rear;
    Object[] queArray;
    int count;

    ArrayQueue(){
        queArray = new Object[10];
        front  = 0;
        rear = -1;
        count  = 0;
        maxSize = count;
    }

    ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queArray = new ArrayQueue[maxSize];
        front  = 0;
        rear = -1;
        count  = 0;

    }

    @Override
    public void enqueue(Object value) {
    if(rear == maxSize-1){
        rear=-1;
    }
        queArray[++rear] = value;
        count++;
    }

    @Override
    public Object dequeue() {
        Object tempObject = queArray[front++];
        if(front == maxSize){
            front = 0;
        }
        count--;

        return tempObject;
    }

    @Override
    public Object peek() {
        return queArray[front];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            Object valueInStack = queArray[i];
            if (value.equals(valueInStack)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for ( int i = 0; i < maxSize; i++){
            queArray[i] =  null;
        }
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = front; i < rear; i++) {
            stringBuilder.append(queArray[i]);
            if (i + 1 != rear) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
