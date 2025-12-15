package com.bridgelabs;

public class LinkedListImpl<T> {

    private Node<T> head;
    private Node<T> tail;

    public T insertFront(T data) {
        Node<T> temp = new Node<T>(data, null, null);
        if(head == null) {
            head = temp;
            tail = temp;
            return head.data;
        }
        temp.next = head;
        head.previous = temp;
        head = temp;
        return head.data;
    }

    public T insertRear(T data) {
        Node<T> temp = new Node<T>(data, null, null);
        if(tail == null){
            head = temp;
            tail = temp;
            return head.data;
        }
        temp.previous = tail;
        tail.next = temp;
        tail = temp;
        return tail.data;
    }

    public void display(){
        if(head == null){
            System.err.println("List is empty");
            return;
        }
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void displayReverse(){
        if(head == null){
            System.out.print("List is empty");
            return;
        }
        Node<T> temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
    }

    public T removeFront(){
        if(head == null){
            System.out.print("List is empty");
            return null;
        }else if (head.next == null) {
            T data = head.data;
            head = null;
            tail = null;
            return data;
        }
        T data = head.data;
        head = head.next;
        head.previous = null;
        return data;
    }

    public T removeRear(){
        if(tail == null){
            System.out.print("List is empty");
            return null;
        }else if(tail.previous == null){
            T data = tail.data;
            tail = null;
            head = null;
            return data;
        }
        T data = tail.data;
        tail = tail.previous;
        tail.next = null;
        return data;
    }

    public int size(){
        int size = 0;
        Node<T> temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public T insert(T data, int index) {
        if (index < 0 || index > size()) {
            System.err.println("Index out of bounds");
            return null;
        }

        if (index == 0) {
            return insertFront(data);
        }

        if (index == size()) {
            return insertRear(data);
        }

        Node<T> temp = head;

        // Move to node at (index)
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node<T> newNode = new Node<>(data, temp, temp.previous);

        temp.previous.next = newNode;
        temp.previous = newNode;

        return newNode.data;
    }

    public T remove(int index) {
        if (index < 0 || index > size()) {
            System.err.println("Index out of bounds");
            return null;
        } else if(index == 0){
            return removeFront();
        } else if(index == size()-1){
            return removeRear();
        }else{
            Node<T> temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            return temp.data;
        }
    }


}
