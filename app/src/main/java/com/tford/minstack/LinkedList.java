package com.tford.minstack;

/**
 * Created by tford on 3/14/17.
 */
public class LinkedList {
    private int value;
    private LinkedList next;

    public LinkedList(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }
}
