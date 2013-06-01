package com.util.random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Random3 {

	 
	public static void main(String[] args) {
		
		Random ran = new Random();
		Set<Integer> set = new HashSet<Integer>();
		
		while (set.size() == 10 ? false : true) {
			int num = ran.nextInt(100) + 1;
			set.add(num);
		}
		
		Iterator<Integer> it = set.iterator();
		int count = 0;
		while (it.hasNext()) {
			System.out.println("第 " + ++count + " 个随机数 = " + it.next());
		}

	}

}
