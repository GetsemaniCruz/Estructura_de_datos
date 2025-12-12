package com.example.demo.singlylist;

import com.example.demo.models.Book;
import com.example.demo.queue.ArrayQueue;

public class SinglyLinkedList {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(Book book) {
        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>());
        }
        book.setActive(true);

        Node newNode = new Node(book);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public Book findById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public Book update(int id, Book updated) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                if (updated.getTitulo() != null) {
                    current.data.setTitulo(updated.getTitulo());
                }
                if (updated.getAutor() != null) {
                    current.data.setAutor(updated.getAutor());
                }
                if (updated.getTotalCopies() >= 0) {
                    current.data.setTotalCopies(updated.getTotalCopies());
                }
                if (updated.getAvailableCopies() >= 0) {
                    current.data.setAvailableCopies(updated.getAvailableCopies());
                }
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public boolean updateStatus(int id, boolean status) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data.setActive(status);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Book[] searchByTitle(String title) {
        Node current = head;
        SinglyLinkedList results = new SinglyLinkedList();
        String searchLower = title.toLowerCase();

        while (current != null) {
            if (current.data.getTitulo().toLowerCase().contains(searchLower)) {
                results.add(current.data);
            }
            current = current.next;
        }
        return results.toArray();
    }

    public Book[] toArray() {
        Book[] arr = new Book[this.size];
        Node current = head;
        int i = 0;

        while (current != null && i < this.size) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public Book[] getAll() {
        return toArray();
    }

    public Node getHead() {
        return head;
    }

}
