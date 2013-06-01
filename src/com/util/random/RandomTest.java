package com.util.random;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random ran1 = new Random();
		
	

		// 创建了两个类Random的对象 
		System.out.println(" Integer:" + ran1.nextInt());
		System.out.println(" Long:" + ran1.nextLong());
		System.out.println(" Float:" + ran1.nextFloat());
		System.out.println(" Double:" + ran1.nextDouble());
		System.out.println(" Gaussian:" + ran1.nextGaussian());

		Random ran2 = new Random(12345);
		
		// 产生各种类型的随机数
		for (int i = 0; i < 5; i++) {
			System.out.println(ran2.nextInt() + " ");
			if (i == 2) {
				System.out.println();
			}

			// 产生同种类型的不同的随机数
			System.out.println();
		} 

	}

}
