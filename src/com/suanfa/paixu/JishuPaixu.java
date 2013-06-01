package com.suanfa.paixu;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * @author Administrator
 *
 */
public class JishuPaixu {

	public static void main(String[] args) {
		int a[] = { 7, 3, 9, 8 };
		
		sort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}

	}

	public static void sort(int[] array) {
		// 首先确定排序的趟数:找出数组中最大的那个数，然后不断对10取余，记录次数，就是这个数组的比较的次数
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		int time = 0;

		// 判断位数
		while (max > 0) {
			max /= 10;
			time++;
		}
		
		// 建立10个队列
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}

		// 进行time次分配和收集
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第time+1位数
				int x = array[j] % (int) Math.pow(10, i + 1)
						/ (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			
			// 元素计数器
			int count = 0;
			// 收集队列元素
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;

				}
			}
		}

	}

}

