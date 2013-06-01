package com.suanfa.paixu;

import java.util.Random;

public class XierPaixu {

	public static void main(String[] args) {
		// 定义数组大小为5
		final int M = 5;
		int[] arr = new int[M];

		for (int i = 0; i < M; i++) {
			arr[i] = new Random().nextInt(100);// 生成100以内的随机数
		}

		display(arr);

		arr = shellSort(arr);

		display(arr);

	}

	/**
	 * 希尔排序也是一种插入排序方法，实际上是一种分组插入方法 先取一个小于n的整数d1作为一个增量，把表的全部记录分成d1个组，所有
	 * 距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序，然后 ，取第二个增量d2(<d1),重复上述的分组和排序，
	 * 直至所取的dt=1,即所有 记录放在同一组中进行直接插入排序为止
	 */
	public static int[] shellSort(int[] array) {

		int gap = array.length / 2;
		int temp;
		while (gap > 0) {
			for (int i = gap; i < array.length; i++) {
				temp = array[i];
				int j = i - gap;
				while (j >= 0 && temp < array[j]) {
					array[j + gap] = array[j];
					j = j - gap;
				}
				array[j + gap] = temp;
			}
			gap = gap / 2;
		}
		return array;
	}

	public static void display(int[] R) {
		System.out.println();
		for (int i = 0; i < R.length; i++) {
			System.out.print(R[i] + "->");
		}
	}

}
