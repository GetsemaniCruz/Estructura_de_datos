package com.example.demo.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class HistoryAction {
    public enum Type {
        CREATE_LOAN,
        RETURN_LOAN,
        ADD_TO_WAITLIST
    }

    private Type type;
    private Loan loan;
    private int userId;
    private int bookId;
}