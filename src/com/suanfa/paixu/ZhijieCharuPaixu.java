package com.suanfa.paixu;

/**
 * 直接插入排序
 */
public class ZhijieCharuPaixu {

	public static void main(String[] args) {
		int[] a = { 12, 3, 41, 23, 6, 9, 19, 0 };

		sort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}

	}

	public static int[] sort(int[] arr) {

		int tmp = 0;
		for (int i = 1; i < arr.length; i++) {

			tmp = arr[i];

			int j = i - 1;

			while (j >= 0 && tmp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = tmp;

		}

		return arr;
	}

}
