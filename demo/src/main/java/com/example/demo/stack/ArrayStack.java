package com.example.demo.stack;

import com.example.demo.models.HistoryAction;

public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        if (top == data.length) {
            expand(); // Llama a la expansión manual
        }
        data[top++] = element;
    }

    private void expand() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return (T) data[top - 1];
    }

    @Override
    public void clear() {
        this.data = new Object[10];
        this.top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("null");
    }

    public HistoryAction[] toArray() {
        HistoryAction[] arr = new HistoryAction[top];
        for (int i = 0; i < top; i++) {
            arr[i] = (HistoryAction) data[i];
        }
        return arr;
    }
}
