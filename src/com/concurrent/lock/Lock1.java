package com.concurrent.lock;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock1 {
  
	
	 
	public static void main(String[] args) {
		
		Stack sck;
		
		String name;
		Lock l = null;
		
		l = new ReentrantLock();
		l.lock();
		try{
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			l.unlock();
		}

		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("xxx", "xxx");
		chm.get("xxx");
		
		
		CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<String>();
		cow.add("xx1");
		
		CopyOnWriteArraySet<String> cosl = new CopyOnWriteArraySet<String>();
		cosl.add("xx2"); 
		
		
		Queue q;
		 
	 
	}
 

}
