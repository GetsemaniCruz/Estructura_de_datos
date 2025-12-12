package com.example.demo.singlylist;

import com.example.demo.models.Loan;

public class LNode {
    Loan data;
    LNode next;

    public LNode(Loan data) {
        this.data = data;
        this.next = null;
    }
}
