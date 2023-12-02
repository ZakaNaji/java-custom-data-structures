package com.znaji;

public interface CustomLinkedList<T> {

    void append(T value);

    void prepend(T value);

    void removeLast();

    boolean remove(int index);

    void reverse();

    T get(int index);

    boolean set(int index, T value);

    boolean insert(int index, T value);

    void getHead();
    void getTail();
    void getLength();
}
