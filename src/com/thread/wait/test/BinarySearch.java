package com.thread.wait.test;

public class BinarySearch { 
	
	/**
	 * 二分查找算法 : 在有序表R[0..n-1]中进行二分查找，成功时返回结点的位置，失败时返回-1 　　
	 * 
	 * @param srcArray
	 *            有序数组
	 * @param key
	 *            查找元素
	 * @return key的数组下标，没找到返回-1
	 * */
	public static void main(String[] args) {
		int srcArray[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81,
				95, 101 };
		System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
	}

	/**
	 * 二分查找递归实现
	 * 
	 * @param srcArray
	 * @param start
	 * @param end
	 * @param key
	 * @return
	 */
	public static int binSearch(int srcArray[], int start, int end, int key) {
		int mid = (end - start) / 2 + start;
		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return -1;
		} else if (key > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, key);
		}
		return -1;
	}

	/**
	 * 二分查找普通循环实现
	 * 
	 * @param srcArray
	 * @param key
	 * @return
	 */
	public static int binSearch(int srcArray[], int key) {
		int mid = srcArray.length / 2;
		if (key == srcArray[mid]) {
			return mid;
		}
		int start = 0;
		int end = srcArray.length - 1;
		while (start <= end) {
			// 使用 (low + high) / 2 会有整数溢出的问题
			mid = (end - start) / 2 + start;
			if (key < srcArray[mid]) {
				// 继续在R[low..mid-1]中查找
				end = mid - 1;
			} else if (key > srcArray[mid]) {
				// 继续在R[mid+1..high]中查找
				start = mid + 1;
			} else {
				return mid;
			}
		}

		// 当low>high时表示查找区间为空，查找失败
		return -1;
	}
 

}
