package com.tford.minstack;

/**
 * Created by tford on 3/14/17.
 */
public class MinStack {
    private LinkedList values;
    private LinkedList mins;
    private int length;

    public MinStack() {

    }

    public void push(Integer value) {
        LinkedList valueNode = new LinkedList(value);
        valueNode.setNext(values);
        values = valueNode;
        length += 1;
        if (mins == null || value <= mins.getValue()) {
            LinkedList minNode = new LinkedList(value);
            minNode.setNext(mins);
            mins = minNode;
        }
    }

    public Integer pop() {
        if (values == null) {
            return null;
        }
        Integer popped = values.getValue();
        values = values.getNext();
        length -= 1;
        if (popped.equals(mins.getValue())) {
            mins = mins.getNext();
        }
        return popped;
    }

    public Integer getMin() {
        if (mins == null) {
            return null;
        }
        return mins.getValue();
    }

    public Integer[] valuesToArray() {
        Integer[] integers = new Integer[length];
        LinkedList p = values;
        int i = 0;
        while (p != null) {
            integers[i] = p.getValue();
            i += 1;
            p = p.getNext();
        }
        return integers;
    }

}
