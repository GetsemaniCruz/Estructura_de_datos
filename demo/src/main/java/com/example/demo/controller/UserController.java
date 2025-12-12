package com.example.demo.controller;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("Error de Validación", "El nombre del usuario es obligatorio.")
            );
        }
        User createdUser = userService.create(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("ID Inválido", "El ID de usuario debe ser un número positivo.")
            );
        }
        User user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("No Encontrado", "Usuario con ID " +id+ " no existe.")
            );
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<User[]> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

}