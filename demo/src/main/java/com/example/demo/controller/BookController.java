package com.example.demo.controller;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        if (book.getTitulo() == null || book.getTitulo().isBlank() || book.getAutor() == null) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("Error de Validación", "El título y autor del libro son obligatorios.")
            );
        }
        Book created = bookService.create(book);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(@RequestParam(required = false) String title) {
        if (title != null && !title.isBlank()) {
            return ResponseEntity.ok(bookService.searchByTitle(title));
        }
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getById(id);
        if (book == null) {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("No Encontrado", "Libro con ID " + id + " no existe.")
            );
        }
        return ResponseEntity.ok(book);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.update(id, bookDetails);

        if (updatedBook == null) {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("No Encontrado", "Libro con ID " + id + " no existe para actualizar.")
            );
        }
        return ResponseEntity.ok(updatedBook);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateBookStatus(@PathVariable int id, @RequestParam boolean active) {
        boolean success = bookService.updateStatus(id, active);

        if (success) {
            return ResponseEntity.ok("Estado del libro con ID " + id + " actualizado a " + (active ? "ACTIVO" : "INACTIVO") + ".");
        } else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("No Encontrado", "Libro con ID " + id + " no existe.")
            );
        }
    }

    @GetMapping("/{id}/waitlist/position")
    public ResponseEntity<?> getWaitlistPosition(@PathVariable int id, @RequestParam int userId) {
        if (userId <= 0) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("ID Inválido", "El ID de usuario debe ser positivo.")
            );
        }

        Object result = bookService.getWaitlistPosition(id, userId);

        if (result instanceof ErrorResponse) {
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok("El usuario está en la posición: " + result);
    }

    @DeleteMapping("/{id}/waitlist")
    public ResponseEntity<?> removeUserFromWaitlist(@PathVariable int id, @RequestParam int userId) {
        if (userId <= 0) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("ID Inválido", "El ID de usuario debe ser positivo.")
            );
        }

        Object result = bookService.removeUserFromWaitlist(id, userId);

        if (result instanceof ErrorResponse) {
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

}
