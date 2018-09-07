package com.briup.day12;

public class LinkedTest {
	public static void main(String[] args) {

		Linked myLinkedList = new Linked();
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
