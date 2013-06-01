package com.thread.wait.test;

class DoubleLinkedList {
	/**
	 * 节点类Node
	 */
	private static class Node {
		Object value;
		Node prev = this;
		Node next = this;

		Node(Object v) {
			value = v;
		}

		public String toString() {
			return value.toString();
		}
	}

	private Node head = new Node(null); // 头节点
	private int size; // 链表大小

	// 以下是接口方法
	public boolean addFirst(Object o) {
		addAfter(new Node(o), head);
		return true;
	}

	public boolean addLast(Object o) {
		addBefore(new Node(o), head);
		return true;
	}

	public boolean add(Object o) {
		return addLast(o);
	}

	public boolean add(int index, Object o) {
		addBefore(new Node(o), getNode(index));
		return true;
	}

	public boolean remove(int index) {
		removeNode(getNode(index));
		return true;
	}

	public boolean removeFirst() {
		removeNode(head.next);
		return true;
	}

	public boolean removeLast() {
		removeNode(head.prev);
		return true;
	}

	public Object get(int index) {
		return getNode(index).value;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("[");
		Node node = head;
		for (int i = 0; i < size; i++) {
			node = node.next;
			if (i > 0)
				s.append(", ");
			s.append(node.value);
		}
		s.append("]");
		return s.toString();
	}

	// 以下是实现方法

	private Node getNode(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node node = head.next;
		for (int i = 0; i < index; i++)
			node = node.next;
		return node;
	}

	private void addBefore(Node newNode, Node node) {
		newNode.next = node;
		newNode.prev = node.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}

	private void addAfter(Node newNode, Node node) {
		newNode.prev = node;
		newNode.next = node.next;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}

	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = null;
		node.next = null;
		size--;
	}
}
// 有些地方还可以优化，比如查找时可以判断索引是否大于size的一半，如果是的话，就从另一头开始迭代。
