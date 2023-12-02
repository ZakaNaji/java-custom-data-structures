package com.znaji;

import java.util.Optional;

public class CustomLinkedListImpl<T> implements CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public CustomLinkedListImpl(T value) {
        final Node<T> node = new Node<>(value, null);
        head = node;
        tail = node;
        size++;
    }

    @Override
    public void append(T value) {
        final Node<T> node = new Node<>(value, null);
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public void prepend(T value) {
        final Node<T> node = new Node<>(value, null);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void removeLast() {
        Node<T> node = head;
        while (node != null) {
            if (size == 1) {
                tail = null;
                head = null;
                size = 0;
                return;
            }
            if (node.next == tail) {
                node.next = null;
                tail = node;
                size--;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }
        final Node<T> tempNode = getNode(index - 1);
        tempNode.next = tempNode.next.next;
        size--;
        return true;
    }

    @Override
    public void reverse() {
        Node<T> temp = head;
        head = tail;
        tail = temp;

        Node<T> before = null;
        Node<T> after = temp.next;

        for (int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    private void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public T get(int index) {
        final Node<T> node = getNode(index);
        if (node == null) return null;
        return node.value;
    }

    @Override
    public boolean set(int index, T value) {
        final Node<T> node = getNode(index);
        if (node == null) return false;
        node.value = value;
        return true;
    }

    @Override
    public boolean insert(int index, T value) {
        if (index < 0 || index > size) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == size) {
            append(value);
            return true;
        }
        final Node<T> tempNode = getNode(index - 1);
        final Node<T> newNode = new Node<>(value, tempNode.next);
        tempNode.next = newNode;
        size++;
        return true;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;


        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void getHead() {
        Optional.ofNullable(head)
                .ifPresentOrElse(node -> System.out.println(node.value), () -> System.out.println("null"));
    }

    public void getTail() {
        Optional.ofNullable(tail)
                .ifPresent(node -> System.out.println(node.value));
    }

    public void getLength() {
        System.out.println(size);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        Node<T> node = head;
        while (node != null) {
            result.append(node.value).append(" ");
            node = node.next;
        }

        return result.toString() + " | " + size;
    }
}
