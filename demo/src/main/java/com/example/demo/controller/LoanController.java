package com.example.demo.controller;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.LoanRequest;
import com.example.demo.models.Loan;
import com.example.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody LoanRequest request) {
        if (request.getUserId() <= 0 || request.getBookId() <= 0) {
            ErrorResponse error = new ErrorResponse("Datos Inválidos", "Los IDs de usuario y libro deben ser positivos.");
            return ResponseEntity.badRequest().body(error);
        }

        Loan loan = loanService.createLoan(request.getUserId(), request.getBookId());

        if (loan != null) {
            return ResponseEntity.status(201).body(loan);
        } else {
            return ResponseEntity.ok("No hay copias disponibles. Usuario agregado a la lista de espera o libro no encontrado.");
        }
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<?> returnLoan(@PathVariable int loanId) {
        if (loanId <= 0) {
            ErrorResponse error = new ErrorResponse("ID Inválido", "El ID del préstamo debe ser positivo.");
            return ResponseEntity.badRequest().body(error);
        }

        boolean success = loanService.returnLoan(loanId);

        if (success) {
            return ResponseEntity.ok("Préstamo con ID " + loanId + " devuelto correctamente.");
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponse(
                    "Error en Devolución",
                    "Préstamo no encontrado o ya marcado como devuelto."
            ));
        }
    }

    @GetMapping("/active")
    public ResponseEntity<Loan[]> getActiveLoans() {
        return ResponseEntity.ok(loanService.getActiveLoans());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Loan[]> getLoansByUser(@PathVariable int userId) {
        if (userId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(loanService.getLoansByUser(userId));
    }
}
