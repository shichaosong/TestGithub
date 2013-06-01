package com.thread;

/**
 * @author Rollen-Holt 继承Thread类,直接调用run方法
 * */
public class TestThread {

	public static void main(String[] args) {
        hello h1=new hello("A");
        hello h2=new hello("B");
        h1.start();
        h2.start();
        h2.start();
        
	}
	
	
}


class hello extends Thread {
	 
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
