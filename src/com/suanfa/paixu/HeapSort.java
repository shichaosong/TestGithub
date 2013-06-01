package com.suanfa.paixu;

/**
 * 堆排序
 * 
 * @author shichao.song
 * 
 */
public class HeapSort {

	public static void main(String[] args) {
		// 数组0下标元素作为暂存单元
		int[] array = { 0, 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5,
				4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		// int[] array = { 0, 49, 38, 65, 97, 76, 13, 27, 49 };

		heapSort(array);

		for (int i = 1; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	/**
	 * 排序函数 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		// 对数组进行筛选，建成一个大顶堆
		double len = array.length - 1;
		for (int i = (int) Math.floor(len / 2); i > 0; i--) {
			heapAdjust(array, i, array.length - 1);
		}
		for (int i = array.length - 1; i > 1; i--) {
			// 将堆顶元素与最后一个元素调换位置，即输出最大值
			swap(array, 1, i);
			// 将最后一位剔出，数组最大下标变为i-1。自队顶至叶子进行调整，形成一个新堆，此过程称为筛选
			heapAdjust(array, 1, i - 1);
		}
	}

	// 建堆函数，认为【s，m】中只有 s
	// 对应的关键字未满足大顶堆定义，通过调整使【s，m】成为大顶堆== 
	public static void heapAdjust(int[] array, int s, int m) {
		// 用0下标元素作为暂存单元
		array[0] = array[s];
		// 沿孩子较大的结点向下筛选
		for (int j = 2 * s; j <= m; j *= 2) {
			// 保证j为较大孩子结点的下标，j < m 保证 j+1 <= m ，不越界
			if (j < m && array[j] < array[j + 1]) {
				j++;
			}
			if (!(array[0] < array[j])) {
				break;
			}
			// 若S位较小，应将较大孩子上移
			array[s] = array[j];
			// 较大孩子的值变成S位的较小值，可能引起顶堆的不平衡，故对其所在的堆进行筛选
			s = j;
		}
		// 若S位较大，则值不变；否则，S位向下移动至2*s、4*s、。。。
		array[s] = array[0];
	}

	/**
	 * 交换函数 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
