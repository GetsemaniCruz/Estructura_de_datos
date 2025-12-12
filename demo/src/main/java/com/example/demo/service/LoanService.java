package com.example.demo.service;

import com.example.demo.singlylist.LoLinkedList;
import com.example.demo.models.Loan;
import com.example.demo.models.Book;
import com.example.demo.models.HistoryAction;
import com.example.demo.stack.ArrayStack;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoLinkedList loans = new LoLinkedList();
    private final ArrayStack<HistoryAction> history = new ArrayStack<>();

    private final BookService bookService;


    public LoanService(BookService bookService) {
        this.bookService = bookService;
    }

    public Loan[] getLoans() {
        return (Loan[]) loans.toArray();
    }

    public boolean removeLoan(int id) {
        return loans.remove(id);
    }

    public Loan createLoan(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return null;
        if (book.getAvailableCopies() > 0) {
            int newId = loans.size() + 1;

            Loan loan = new Loan(newId, userId, bookId, false);
            loans.add(loan);

            book.setAvailableCopies(book.getAvailableCopies() - 1);
            history.push(new HistoryAction(
                    HistoryAction.Type.CREATE_LOAN,
                    loan,
                    userId,
                    bookId
            ));

            return loan;
        }
        book.getWaitlist().offer(userId);
        history.push(new HistoryAction(
                HistoryAction.Type.ADD_TO_WAITLIST,
                null,
                userId,
                bookId
        ));
        return null;
    }

    public boolean returnLoan(int loanId) {
        Loan loan = findById(loanId);
        if (loan == null || loan.isReturned()) return false;

        loan.setReturned(true);
        Book book = bookService.getById(loan.getBookId());
        if (book == null) return false;
        history.push(new HistoryAction(
                HistoryAction.Type.RETURN_LOAN,
                loan,
                loan.getUserId(),
                loan.getBookId()
        ));

        if (!book.getWaitlist().isEmpty()) {
            Integer nextUser = book.getWaitlist().poll();
            if (nextUser != null) {
                createLoan(nextUser.intValue(), book.getId());
            } else {
                book.setAvailableCopies(book.getAvailableCopies() + 1);
            }
        } else {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
        }

        return true;
    }

    public Loan findById(int id) {
        Object[] arr = loans.toArray();
        for (Object o : arr) {
            Loan l = (Loan) o;
            if (l.getId() == id) return l;
        }
        return null;
    }

    public Loan[] getActiveLoans() {
        LoLinkedList list = new LoLinkedList();

        for (Object o : loans.toArray()) {
            Loan l = (Loan) o;
            if (!l.isReturned()) {
                list.add(l);
            }
        }

        return (Loan[]) list.toArray();
    }

    public Loan[] getLoansByUser(int userId) {
        LoLinkedList list = new LoLinkedList();

        for (Object o : loans.toArray()) {
            Loan l = (Loan) o;
            if (l.getUserId() == userId) {
                list.add(l);
            }
        }

        return (Loan[]) list.toArray();
    }

    public ArrayStack<HistoryAction> getHistoryStack() {
        return history;
    }
}
