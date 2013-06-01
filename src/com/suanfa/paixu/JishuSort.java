package com.suanfa.paixu;

import java.util.ArrayList;

public class JishuSort {

	/**
	 * 基数排序算法思想： 先找出最大的数有几位数，这样就确定了要进行几次排序， 然后建立10个数组进行存放第n位数为0,1,2...9的数字，
	 * 存放完之后要进行收集10个数组中的数字到原来的数组中， 然后在进行排序 第i位数为0,1,2...9的计算方法：array[j] %
	 * Math.pow(10, i+1) / Math.pow(10,i)
	 * 即第一位数直接除以10的余数就行了，第二位数，则除以100得余数，再除以10得商即为第二位数，以此类推。
	 * 
	 * @param array
	 *            要进行基数排序的数组
	 */
	public void radixSort(int[] array) {
		int max, time;
		// 确定最大的数有几位数，确定排序的次数
		max = array[0];
		for (int i = array.length - 1; i > 0; i--) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		time = 0;
		while (max > 0) {
			max /= 10;
			time++;
		}
		
		// 建立10个数组
		ArrayList<Integer>[] quene = new ArrayList[10];
		for (int i = 0; i < 10; i++) {
			quene[i] = new ArrayList<Integer>();
		}

		// 分别进行time次分配和收集数组，根据不同的位数进行分配到数组中，再收集到原来的数组中
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < array.length; j++) {
				int index = (int) (array[j] % (int) Math.pow(10, i + 1) / Math
						.pow(10, i));
				quene[index].add(array[j]);
			}
			// 收集完了之后进行分配
			int count = 0;
			for (int k = 0; k < 10; k++) {
				while (quene[k].size() > 0) {
					array[count] = quene[k].remove(0);
					count++;
				}
			}
		}
	}

	/**
	 * 计数排序基本思想： 计算数组中每个元素x中比x小的元素个数， 然后就可以把x放在相应位置上 如：有15个数小于x，则x位于第16个位置上。
	 * 
	 * @param data
	 *            待排序数组
	 * @param k
	 *            排序数组中最大的数
	 */
	public int[] countingSort(int[] data, int k) {
		int result[] = new int[data.length];
		int[] temp = new int[k + 1];
		
		// 先初始化临时数组，即保存小于元素x的个数的数组
		for (int i = 0; i < temp.length; i++) {
			temp[i] = 0;
		}
		
		// temp [i]即包含等于i的元素个数
		for (int i = 0; i < data.length; i++) {
			temp[data[i]] = temp[data[i]] + 1;
		}
		
		// temp [i]即包含小于等于i的元素个数
		for (int i = 1; i < temp.length; i++) {
			temp[i] = temp[i] + temp[i - 1];
		}
		
		// 将结果放入result数组，A[j]直接放在最终位置(小于等于A[j]的个数加1的位置)
		// temp[data[j]]+1上，由于数组下标和位置相差1
		for (int j = data.length - 1; j >= 0; j--) {
			int index = temp[data[j]];
			result[index - 1] = data[j];
			temp[data[j]]--;
		}
		
		return result;
	}

	/**
	 * 得到数组中的最大数，用于计数排序
	 * 
	 * @param data
	 *            待计算数组
	 * @return 返回最大数
	 */
	public int getMax(int[] data) {
		int max = data[0];
		for (int i = data.length - 1; i > 0; i--) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		JishuSort redix = new JishuSort();

		int[] testData = { 2, 10, 78, 189, 354, 8, 756, 390, 356 };

		// 基数排序测试
		System.out.println(" 基数排序测试");
		redix.radixSort(testData);
		for (int data : testData) {
			System.out.print(data + "->");
		}

		// 计数排序测试
		System.out.println("\n\n 计数排序测试");
		int[] testData2 = { 9, 3, 5, 3, 6, 5, 3, 7, 4, 9 };
		int max = redix.getMax(testData2);
		int[] countSort = redix.countingSort(testData2, max);
		for (int data : countSort) {
			System.out.print(data + "->");
		}
	}

}
