package com.example.demo.singlelinked;

import com.example.demo.models.User;

public class UNode {
    public User data;
    public UNode next;

    public UNode(User data) {
        this.data = data;
        this.next = null;
    }
}
