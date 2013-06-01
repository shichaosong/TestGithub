package com.suanfa.paixu;

class Queue {
	private int front;
	private int back;
	private int size;
	private Object[] data;

	public Queue() {
		data = new Object[10];
	}

	public int getSize() {
		return size;
	}

	public Object dequeue() {
		Object o = null;
		if (size > 0) {
			size--;
			o = data[front];
			data[front] = null;
			front = (front > data.length - 1) ? 0 : front + 1;
		}
		return o;
	}

	public void enqueue(Object o) {
		if (size >= data.length) {
			Object[] newData = new Object[data.length * 2];
			for (int i = 0; i < data.length; ++i) {
				newData[i] = data[i];
			}
			data = newData;
		}
		data[back] = o;
		back++;
		size++;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			Object o = data[i];
			if (o != null) {
				str.append(o + " -> ");
			}
		}
		
		return str.toString();
	}

}

public class TestQueue  {
	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 0; i < 15; i++) {
			queue.enqueue("xxx" + i);
		}
		
		System.out.println(queue);
		System.out.println(queue.getSize());
		System.out.println("----------------------");
		
		for (int i = 0; i < 10; i++) {
			queue.dequeue();
		}
		
		System.out.println(queue);
		System.out.println(queue.getSize());
		System.out.println("----------------------");
		
		for (int i = 0; i < 5; i++) {
			queue.enqueue("www" + i);
		}
		
		System.out.println(queue);
		System.out.println(queue.getSize());

	}

}
