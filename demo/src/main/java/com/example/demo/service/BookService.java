package com.example.demo.service;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.models.Book;
import com.example.demo.queue.ArrayQueue;

import com.example.demo.singlylist.SinglyLinkedList;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final SinglyLinkedList books = new SinglyLinkedList();
    private static final int MAX_WAITLIST = 50;

    @PostConstruct
    public void init() {
        Book b1 = new Book(1, "Luz y sombra", "Maria Contreras", 100, 10, true, new ArrayQueue<>());
        books.add(b1);

        Book b2 = new Book(2, "Como agua para chocolate", "Carlos Villareal", 100, 10, true, new ArrayQueue<>());
        books.add(b2);

        Book b3 = new Book(3, "La magia de la amistad", "Twilight Sparkle", 100, 0, true, new ArrayQueue<>());
        books.add(b3);

        System.out.println(">>> Libros precargados en LinkedList.");
    }

    public Book create(Book book) {
        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>());
        }
        book.setActive(true);
        books.add(book);
        return book;
    }

    public Book update(int id, Book data) {
        return books.update(id, data);
    }

    public boolean updateStatus(int id, boolean status) {
        return books.updateStatus(id, status);
    }

    public Book[] searchByTitle(String title) {
        return books.searchByTitle(title);
    }

    public Book findById(int id) {
        return books.findById(id);
    }

    public Book[] getAll() {
        return books.toArray();
    }

    public Book getById(int id) {
        return books.findById(id);
    }

    public Object joinWaitlist(int idBook, int userId) {

        Book book = books.findById(idBook);

        if (book == null) {
            return new ErrorResponse("No se encontro el libro", "No existe un libro con el ID " + idBook);
        }

        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>());
        }

        ArrayQueue<Integer> queue = book.getWaitlist();
        if (queue.indexOf(userId) != -1) {
            return new ErrorResponse("Usuario ya en lista", "El usuario ya tiene una reserva para este libro.");
        }

        if (queue.getSize() >= MAX_WAITLIST) {
            return new ErrorResponse("Lista de espera llena", "La lista de espera ha llegado a su límite de " + MAX_WAITLIST);
        }
        queue.offer(userId);
        return "Agregado a la lista de espera en la posición: " + queue.getSize();
    }

    public Object getWaitlistPosition(int idBook, int userId) {
        Book book = books.findById(idBook);

        if (book == null) {
            return new ErrorResponse("No encontrado", "No existe un libro con el ID " + idBook);
        }

        if (book.getWaitlist() == null) {
            return new ErrorResponse("Sin lista", "Este libro no tiene una lista de espera activa.");
        }

        int position = book.getWaitlist().indexOf(userId);

        if (position != -1) {
            return position;
        } else {
            return new ErrorResponse("No encontrado", "El usuario con ID " + userId + " no está en la lista de espera.");
        }
    }

    public Object removeUserFromWaitlist(int idBook, int userId) {
        Book book = books.findById(idBook);

        if (book == null) {
            return new ErrorResponse("No encontrado", "No existe un libro con el ID " + idBook);
        }

        if (book.getWaitlist() == null) {
            return new ErrorResponse("Sin lista", "Este libro no tiene una lista de espera.");
        }

        if (book.getWaitlist().remove(userId)) {
            return "Reserva cancelada exitosamente para el usuario " + userId + ".";
        } else {
            return new ErrorResponse("No encontrado", "El usuario no tenía una reserva activa para este libro.");
        }
    }
}
