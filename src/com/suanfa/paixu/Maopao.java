package com.suanfa.paixu;

/**
 * 冒泡排序 Bubble Sort
 * 最简单的排序方法是冒泡排序方法。这种方法的基本思想是，将待排序的元素看作是竖着排列的“气泡”，较小的元素比较轻，从而要往上浮。
 * 在冒泡排序算法中我们要对这个“气泡”序列处理若干遍。所谓一遍处理，就是自底向上检查一遍这个序列，并时刻注意两个相邻的元素的顺序是否正确。
 * 如果发现两个相邻元素的顺序不对，即“轻”的元素在下面，就交换它们的位置。显然，处理一遍之后，“最轻”的元素就浮到了最高位置；
 * 处理二遍之后，“次轻”的元素就浮到了次高位置。在作第二遍处理时，由于最高位置上的元素已是“最轻”元素，所以不必检查。
 * 一般地，第i遍处理时，不必检查第i高位置以上的元素，因为经过前面i-1遍的处理，它们已正确地排好序。
 * 
 * <pre>
 *  冒泡也与初始排序次序有关，因为一般在实现冒泡排序时，都采用改进算法，设置一个标志位flag，将其初始值设置为非0，表示被排序的表示是一个无序的表，
 *  每一次排序开始前设置flag值为0，在进行数据交换时，修改flag为非0。在新一轮排序开始时，检查此标志，若此标志为0，表示上一次没有做过交换数据，
 * 则结束排序； 否则进行排序。所以，当记录序列的初始状态为"正序"，则冒泡排序过程只需进行一趟排序即可
 * 
 * <pre>
 * 改进的冒泡排序算法
 * <a>http://blog.csdn.net/tjunxin/article/details/8711389
 * 
 */
public class Maopao {

	public static void main(String[] args) {
		int[] tempData = new int[] { 9, 3, 5, 6, 2, 4, 8 };

		print(tempData);
		// 原始算法
		// tempData = doBubbleSort(tempData);
		// 第一种优化
		BubbleSort_2(tempData, tempData.length);
		// 第二种优化
		// BubbleSort_3(tempData, tempData.length);

		print(tempData);

	}

	static int[] doBubbleSort(int[] src) {
		int len = src.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int temp;
				if (src[i] > src[j]) {
					temp = src[j];
					src[j] = src[i];
					src[i] = temp;
				}
			}
		}

		return src;
	}

	/**
	 * 第一步优化 
	 * 如果上面代码中，里面一层循环在某次扫描中没有执行交换，则说明此时数组已经全部有序列，无需再扫描了。
	 * 因此，增加一个标记，每次发生交换，就标记，如果某次循环完没有标记，则说明已经完成排序。
	 * 
	 */
	public static void BubbleSort_2(int a[], int size) {
		// 注意这个默认值不能初始为 true
		boolean bSwaped = false;  
		for (int i = 0; i < size - 1; i++) {
			// 每次先重置为false
			bSwaped = true;
			for (int j = size - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

					bSwaped = false;
				}

			}
			// 如果上一次扫描没有发生交换，则说明数组已经全部有序，退出循环
			if (!bSwaped) {
				break;
			}

		}
	}
	 
	/**
	 * 第一步优化的第二种实现方式
	 * @param a
	 * @param n
	 */
	void BubbleSort2(int a[], int n) {
		int j, k;
		boolean flag;

		k = n;
		flag = true;
		while (flag) {
			flag = false;
			for (j = 1; j < k; j++)
				if (a[j - 1] > a[j]) { 
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

					flag = true;
				}
			k--;
		}
	}

	/**
	 * 第二步优化 
	 * 在第一步优化的基础上发进一步思考：如果R[0..i]已是有序区间，上次的扫描区间是R[i..n]，记上次扫描时最后
	 * 一次执行交换的位置为lastSwapPos，
	 * 则lastSwapPos在i与n之间，不难发现R[i..lastSwapPos]区间也是有序的，否则这个区间也会发生交换；
	 * 所以下次扫描区间就可以由R[i..n] 缩减到[lastSwapPos..n]。
	 * 
	 */
	public static void BubbleSort_3(int a[], int size) {
		for (int i = 0; i < size - 1; i++) {
			int lastSwapPos = i;
			for (int j = size - 1; j > lastSwapPos; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

					lastSwapPos = i;
				}
			}
		}
	}

	static void print(int[] src) {
		for (int i = 0; i < src.length; i++) {
			System.out.println(src[i]);
		}
		System.out.println("---------------");
	}

}
