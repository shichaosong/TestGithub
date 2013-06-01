//package com.thread.producer.consumer;
//
//public class Test {
//	public static void main(String args[]) {
//		Queue q = new Queue();
//
//		Producer p = new Producer(q);
//		Consumer c = new Consumer(q);
//		p.start();
//		c.start(); // 主类Test，q为共享对象实例
//
//	}
//}
//
//class Producer extends Thread {
//	Queue q;
//
//	Producer(Queue q) { // 创建Producer时指定它要放置到哪个队列中邀
//		this.q = q;
//	}
//
//	public void run() { // 放置了0～9，总共10个数字邀
//		for (int i = 0; i < 10; i++) {
//			q.put(i);
//
//			System.out.println("Producer put: " + i); // 打印出具体放置的是哪个数
//		}
//	}
//
//}
//
//class Consumer extends Thread {
//	Queue q;
//
//	Consumer(Queue q) { // 创建Consumer时就为它指定相应的队列
//		this.q = q;
//	}
//
//	public void run() {
//		while (true) {
//			System.out.println("Consumer get:" + q.get()); // 消费者类
//		}
//	}
//}
//
//class Queue {
//	int value; // 用来存放数据
//	boolean isFull = false; // 判断队列是否已满
//
//	public synchronized void put(int i) { // 用来放置数据
//		if (isFull) {
//			value = i;
//			isFull = true;
//			
//			notify();
//
//			try {
//				wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public synchronized int get() { // 用来获取数据邀
//		if (isFull) {
//			try {
//				wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			isFull = false;
//			notify();
//		}
//
//		return value; // 共享缓冲区队列类
//	}
//	
//	
//}
