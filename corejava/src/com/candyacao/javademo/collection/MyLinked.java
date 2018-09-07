package com.candyacao.javademo.collection;

/**
 * 双向链表
 * 
 * @author CLY
 *
 */

public class MyLinked {
	private Node first;
	private Node last;
	private int size = 0;

	/**
	 * 链表中的节点
	 */
	// addFirst
	public void addFirst(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			// 将新增节点的下一个节点指向之前的第一个节点
			node.next = this.first;
			// 将之前的第一个节点的前一个节点指向新增的节点
			this.first.prev = node;
			// 将新增的节点变为头节点
			this.first = node;

		}
		size++;
	}

	// addLast
	public void addLast(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			// 将新增节点的上一个节点指向之前的最后节点
			node.prev = this.last;
			// 将之前的最后一个节点的下一个节点指向新增的节点
			this.last.next = node;
			// 将新增的节点变为尾节点
			this.last = node;

		}
		size++;
	}

	// removeFirst
	public void removeFirst() {
		this.first = this.first.next;
		this.first.prev = null;
		size--;
	}

	// removeLast
	public void removeLast() {
		this.last = this.last.prev;
		this.last.next = null;
		size--;
	}

	// remove
	public void remove(Object ele) {

		// 找到要删除的节点
		Node current = this.first;
		for (int i = 0; i < size; i++) {

			if (!current.ele.equals(ele)) {
				if (current.next == null) {
					return;
				}
				current = current.next;
			}
		}

		if (current == this.first) {
			this.first = current.next;
			this.first.prev = null;
		} else if (current == this.last) {
			this.last = current.prev;
			this.last.next = null;
		} else {
			// 把删除节点的上一个节点的next指向删除节点的下一个节点
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}

		size--;

	}

	// toString
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		Node node = this.first;
		for (int i = 1; i <= size; i++) {
			stringBuilder.append(node.ele);
			if (i != size) {
				stringBuilder.append(",");
			} else {
				stringBuilder.append("]");
			}
			node = node.next;
		}
		return stringBuilder.toString();
	}

	public Node getFirst() {
		return this.first;
	}

	public Node getLast() {
		return this.last;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	class Node {
		Node next;
		Node prev;
		Object ele;

		public Node(Object ele) {
			this.ele = ele;
		}
	}
}