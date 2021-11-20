package com.luxsoft.datastructure.list;

public class Node<T> {
    Node<T> next;
    Node<T> prev;
    T value;

    public Node(T value) {
        this.value = value;
        
    }
}
