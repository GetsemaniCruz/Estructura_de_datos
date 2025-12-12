package com.example.demo.singlylist;

import com.example.demo.models.Book;

public class Node {
    public Book data;
    public Node next;

    public Node(Book data) {
        this.data = data;
        this.next = null;
    }
}