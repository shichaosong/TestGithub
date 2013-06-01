package com.thread.wait.test;

class TestThreadMethod extends Thread {
	public static int shareVar = 0;

	public TestThreadMethod(String name) {
		super(name);
	}

	public synchronized void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.println(" : " + i);
			notify();
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				if (Thread.currentThread().getName().equals("t1"))
					Thread.sleep(200);
				else
					Thread.sleep(100);
					
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		TestThreadMethod t1 = new TestThreadMethod("t1");
		TestThreadMethod t2 = new TestThreadMethod("t2");
		t1.start();
		// t1.start();
		t2.start();
	}
}
