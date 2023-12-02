package com.znaji;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedListImpl<>(10);
        myLinkedList.append(20);
        myLinkedList.append(30);
        myLinkedList.append(40);
        myLinkedList.append(50);

        myLinkedList.reverse();
        System.out.println(myLinkedList);
    }
}