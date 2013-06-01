package com.util.random;

public class RandomTest1 {

 
	public static void main(String[] args) {
		
		StringBuffer resRand = new StringBuffer("");
		int maxnum = 0;
		
		while (true) {
			String num = (int) (Math.random() * 100) + "";
			if (maxnum < 10) {
				if (resRand.toString().contains(num)) {
					continue;
				}
				resRand.append(num + ",");
				maxnum++;
			} else {
				break;
			}
		}
		System.out.println(resRand.substring(0, resRand.length() - 1));

	}
	
	

}
