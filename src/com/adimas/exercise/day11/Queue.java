package com.adimas.exercise.day11;

    class Queue extends MyLinkedList {
    private Node tail;

    public Queue() {
        this.tail = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = removeFirst();
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public int peek() {
        return peekFirst();
    }
}
