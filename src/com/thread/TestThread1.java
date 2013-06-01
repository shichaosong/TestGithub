package com.thread;

public class TestThread1 {
 
	public static void main(String[] args) {
		hello h1 = new hello("线程A");
        Thread demo= new Thread(h1);

        hello h2 = new hello("线程B");
        Thread demo1=new Thread(h2);

        demo.start();
        demo1.start();

	}

	/**
	 * @author Rollen-Holt 实现Runnable接口
	 * */
	static class hello implements Runnable {
	 
		String name; 
		
	    public hello() {
	 
	    }
	 
	    public hello(String name) {
	        this.name = name;
	    }
	 
	    public void run() {
	        for (int i = 0; i < 5; i++) {
	            System.out.println(name + "运行     " + i);
	        }
	    }
	}
	        
	        
}
