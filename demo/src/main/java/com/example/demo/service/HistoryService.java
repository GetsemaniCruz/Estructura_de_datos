package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.HistoryAction;
import com.example.demo.stack.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private LoanService loanService;
    @Autowired
    private BookService bookService;

    public HistoryAction undo() {
        ArrayStack<HistoryAction> history = loanService.getHistoryStack();

        if (history.isEmpty()) {
            return null;
        }
        HistoryAction action = history.pop();

        switch (action.getType()) {
            case CREATE_LOAN:
                loanService.removeLoan(action.getLoan().getId());
                Book book1 = bookService.getById(action.getBookId());
                if (book1 != null) {
                    book1.setAvailableCopies(book1.getAvailableCopies() + 1);
                }
                break;

            case RETURN_LOAN:
                action.getLoan().setReturned(false);
                Book book2 = bookService.getById(action.getBookId());
                if (book2 != null) {
                    book2.setAvailableCopies(book2.getAvailableCopies() - 1);
                }
                break;

            case ADD_TO_WAITLIST:
                Book book3 = bookService.getById(action.getBookId());
                if (book3 != null) {
                    book3.getWaitlist().remove(action.getUserId());
                }
                break;

            default:
                System.err.println("Accion no reconocida.");
                return null;
        }

        return action;
    }

    public HistoryAction[] getHistoryArray() {
        return loanService.getHistoryStack().toArray();
    }
}