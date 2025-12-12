package com.example.demo.controller;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.models.HistoryAction;
import com.example.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @PostMapping("/undo")
    public ResponseEntity<?> undoLastAction() {
        HistoryAction action = historyService.undo();

        if (action != null) {
            return ResponseEntity.ok("Acción deshecha exitosamente: " + action.getType().toString());
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponse(
                    "Error de UNDO",
                    "No hay acciones en el historial para deshacer."
            ));
        }
    }

    @GetMapping
    public ResponseEntity<HistoryAction[]> getHistory() {
        return ResponseEntity.ok(historyService.getHistoryArray());
    }
}
