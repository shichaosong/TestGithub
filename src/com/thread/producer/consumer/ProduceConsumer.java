package com.thread.producer.consumer;

public class ProduceConsumer {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer pro = new Producer(ss);
		Consumer con = new Consumer(ss);
		new Thread(pro).start();
		new Thread(con).start();

	}
}

class Product {
	int id;

	public Product(int id) {
		this.id = id;
	}

	public String toString() {
		return "Product:" + id;
	}
}

class SyncStack {
	int index = 0;
	Product[] arrPro = new Product[6];

	public synchronized void push(Product p) {
		while (index == arrPro.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		arrPro[index] = p;
		index++;
		
		this.notify();
		
	}

	public synchronized Product pop() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		index--;
		this.notify();
		
		return arrPro[index];
	}

}

class Producer implements Runnable {
	SyncStack ss = null;

	public Producer(SyncStack ss) { // 持有SyncStack的一个引用
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Product p = new Product(i);
			ss.push(p);
			System.out.println("生产了：" + p);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}

class Consumer implements Runnable {

	SyncStack ss = null;

	public Consumer(SyncStack ss) { // 持有SyncStack的一个引用
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Product p = ss.pop();
			System.out.println("消费了：" + p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
