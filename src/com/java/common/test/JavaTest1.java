package com.java.common.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTest1 {
	
	LinkedList ll;
	ArrayList al;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long userId = 0;
		int a = 3;
		a = 4; 
		

		System.out.println("5<<3 = "+(5<<3));
		
	 
		System.out.println(2<<3);
		
		HashMap<String, String> xx = new HashMap<String, String>();
		
		Hashtable ht;
		
		TreeSet ts;
		
		Thread th;
		
		Arrays ays;
		
		HashSet  hst;
		 
		ArrayBlockingQueue<String> aq = new ArrayBlockingQueue<String>(5);  
        aq.add("xx3");  
        try {  
            aq.put("cc");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        aq.offer("xx");  
        try {  
            aq.take();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        aq.poll();    
 
		
	}

}
