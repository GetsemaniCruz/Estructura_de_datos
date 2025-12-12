package com.example.demo.queue;

public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int rear;
    private int front;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    @Override
    public void offer(T element) {
        if (size == data.length) {
            expandCapacity();
        }

        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if (isEmpty()) {
            System.out.println("La Queue esta vacia");
            return null;
        }

        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La queue esta vacia");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[(front + i) % data.length] = null;
        }
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    private void expandCapacity() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }

        front = 0;
        data = newArr;
        rear = size;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T element) {
        if (isEmpty()) return -1;

        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            if (data[index].equals(element)) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean remove(T element) {
        int position = indexOf(element);

        if (position == -1) {
            return false;
        }

        int indexToRemove = position - 1;
        int targetIndex = (front + indexToRemove) % data.length;

        for (int i = indexToRemove; i < size - 1; i++) {
            int current = (front + i) % data.length;
            int next = (front + i + 1) % data.length;
            data[current] = data[next];
        }
        rear = (rear - 1 + data.length) % data.length;
        data[rear] = null;
        size--;

        return true;
    }

    @Override
    public int getSize() {
        return size;
    }
}
