package com.candyacao.javademo.collection;

public class LinkedTest {
	public static void main(String[] args) {

		MyLinked myLinkedList = new MyLinked();
		myLinkedList.addFirst("java");
		System.out.println(myLinkedList.toString());
		myLinkedList.addFirst("android");
		myLinkedList.addFirst("oracle");
		System.out.println(myLinkedList.toString());

		myLinkedList.addLast("xml");
		System.out.println(myLinkedList.toString());
		myLinkedList.addLast("jdbc");
		System.out.println(myLinkedList.toString());
		myLinkedList.removeFirst();
		System.out.println(myLinkedList.toString());
    myLinkedList.removeLast();
    myLinkedList.remove("java");
	System.out.println(myLinkedList.toString());
	}

}
