package com.suanfa.lianbiao;

class Node<E> {

	// 数据
	public E data;
	// 指向下一个节点
	public Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	// public Node<E> getNext() {
	// return next;
	// }
	//
	// public void setNext(Node<E> next) {
	// this.next = next;
	// }

}

class LinkList<E> {

	public Node<E> head;

	// 链表中数据项的个数
	public int size;

	public LinkList() {
		head = null;
		size = 0;
	}

	// 在表头插入新的数据
	public void insertFirst(E value) {
		Node<E> link = new Node<E>(value);
		link.next = head;
		head = link;
		size++;
	}

	// 判断链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 删除表头
	public Node<E> deleteFirst() {
		Node<E> temp = head;
		head = head.next;
		size--;
		return temp;
	}

	// 输出链表中的所有数据
	public void display() {
		Node<E> curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	// 返回链表中数据项的个数
	public int size() {
		return size;
	}

	// 获取从头至尾的第i个数据项
	public Node<E> get(int i) {
		if (i > size() - 1 || i < 0) {
			try {
				throw new IndexOutOfBoundsException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Node<E> curr = head;
		for (int n = 0; n < size(); n++) {
			if (n == i) {
				return curr;
			} else {
				curr = curr.next;
			}
		}
		return null;
	}

	// 输出从头至尾的第i个数据项
	public void remove(int i) {
		if (i == 0) {
			deleteFirst();
		} else if (i == size() - 1) {
			get(i - 1).next = null;
		} else {
			get(i - 1).next = get(i + 1);
		}
		size--;
	}

	// 其实下面这2个反转的方法原理都是一样的，就是有的把第一个节点当做cur，有的把第二个节点当做cur
	// 两种方式实现单链表的反转(递归、普通)
	public Node<E> reverse_1(Node<E> head) {
		if (head == null) {
			return null;
		}
		// 链表反转后的新头结点
		Node<E> reverseHead = null;
		Node<E> cur = head;
		Node<E> pre = null;

		while (cur != null) {
			Node<E> next = cur.next;
			if (next == null) {
				reverseHead = cur;
			}

			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return reverseHead;
	}

	/**
	 * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
	 * 
	 */
	public Node<E> reverse_2(Node<E> head) {
		if (null == head) {
			return head;
		}
		Node<E> pre = head;
		Node<E> cur = head.next;
		Node<E> next;
		while (null != cur) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		// 将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
		head.next = null;
		head = pre;

		return head;
	}

	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 */
	public Node<E> reverse_3(Node<E> head) {
		if (null == head || null == head.next) {
			return head;
		}

		Node<E> reversedHead = reverse_3(head.next);
		head.next.next = head;
		head.next = null;
		return reversedHead;
	}

}

public class Link_list {
	public static void main(String[] args) {
		LinkList<Long> ll = new LinkList<Long>();

		// 构造链表
		for (int i = 0; i < 10; i++) {
			Long value = (long) (Math.random() * 100);
			ll.insertFirst(value);
		}

		ll.display();

		while (!ll.isEmpty()) {
			ll.deleteFirst();
			ll.display();
		}

		System.out.println("Ok");
	}
}
