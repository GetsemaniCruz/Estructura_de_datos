package com.example.demo.models;


import com.example.demo.queue.ArrayQueue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String titulo;
    private String autor;
    private int totalCopies;
    private int availableCopies;
    private boolean active = true;
    private ArrayQueue<Integer> waitlist;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                ", active=" + active +
                ", waitlist=" + waitlist +
                '}';
    }
}
