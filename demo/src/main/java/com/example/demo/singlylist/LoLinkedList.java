package com.example.demo.singlylist;

import com.example.demo.models.Loan;

public class LoLinkedList {

    private LNode head;
    private int size;

    public LoLinkedList() {
        this.head = null;
    }

    public void add(Loan loan) {
        LNode newNode = new LNode(loan);

        if (head == null) {
            head = newNode;
        } else {
            LNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Loan[] toArray() {
        Loan[] arr = new Loan[size];
        LNode curr = head;
        int i = 0;

        while (curr != null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    public Loan findById(int id) {
        LNode current = head;

        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public Loan[] getActive() {
        int count = 0;
        LNode current = head;

        while (current != null) {
            if (!current.data.isReturned()) {
                count++;
            }
            current = current.next;
        }

        Loan[] result = new Loan[count];
        current = head;

        int i = 0;
        while (current != null) {
            if (!current.data.isReturned()) {
                result[i++] = current.data;
            }
            current = current.next;
        }

        return result;
    }

    public Loan[] findByUser(int userId) {
        int count = 0;
        LNode current = head;

        while (current != null) {
            if (current.data.getUserId() == userId) {
                count++;
            }
            current = current.next;
        }

        Loan[] result = new Loan[count];
        current = head;
        int i = 0;

        while (current != null) {
            if (current.data.getUserId() == userId) {
                result[i++] = current.data;
            }
            current = current.next;
        }

        return result;
    }

    public boolean remove(int id) {
        if (head == null) return false;

        if (head.data.getId() == id) {
            head = head.next;
            size--;
            return true;
        }

        LNode current = head;
        while (current.next != null && current.next.data.getId() != id) {
            current = current.next;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        size--;
        return true;
    }

    public void printList(){
        LNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }

}
