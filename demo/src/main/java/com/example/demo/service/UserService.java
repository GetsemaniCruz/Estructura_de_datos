package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.singlelinked.SingleLinkedList;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    private final SingleLinkedList users = new SingleLinkedList();
    private int nextId = 1;


    @PostConstruct
    public void init() {
        create(new User(0, "James", true));
        create(new User(0, "Victoria", true));
        create(new User(0, "Charlie", true));

        System.out.println(">>> Usuarios precargados");
    }

    public User create(User user) {
        user.setId(nextId++);
        user.setActive(true);
        users.add(user);
        return user;
    }

    public User[] getAll() {
        return users.toArray();
    }

    public User getById(int id) {
        return users.findById(id);
    }
    public User update(int id, User data) {
        return users.update(id, data);
    }

    public boolean delete(int id) {
        return users.remove(id);
    }
}
