package com.adimas.exercise.day11;

class Stack extends MyLinkedList {

    // Push to stack (adds to the front for O(1) operation)
    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Pop from stack (removes from front)
    public int pop() {
        return removeFirst();
    }

    // Peek at the top of the stack (does not remove)
    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }
}
