package com.bridgelabs;

import java.util.LinkedList;

public class StackImpl<T> {

    private LinkedListImpl<T> stack;

    public T push(T data) {
        return stack.insertRear(data);
    }

    public T pop() {
        return stack.removeRear();
    }

    public void display() {
        stack.displayReverse();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


}

