package com.bridgelabs;

public class QueueImpl<T> {

    private LinkedListImpl<T> queue;

    public T insert(T data){
        return queue.insertRear(data);
    }

    public T remove(){
        return queue.removeFront();
    }

    public int size(){
       return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void display(){
        queue.display();
    }

}
