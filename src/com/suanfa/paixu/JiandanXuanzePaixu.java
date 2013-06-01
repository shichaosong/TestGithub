package com.suanfa.paixu;

/**
 * 选择排序 Selection Sort  -- 直接选择排序
 * 
 * 选择排序的基本思想是：对待排序的记录序列进行n-1遍的处理，第1遍处理是将L[1..n]中最小者与L[1]交换位置，
 * 第2遍处理是将L[2..n]中最小者与L[2]交换位置，......，第i遍处理是将L[i..n]中最小者与L[i]交换位置。
 * 这样，经过i遍处理之后，前i个记录的位置就已经按从小到大的顺序排列好了。 　　
 * 当然，实际操作时，也可以根据需要，通过从待排序的记录中选择最大者与其首记录交换位置，按从大到小的顺序进行排序处理。
 */
public class JiandanXuanzePaixu {
 
	public static void main(String[] args) {
		int[] tempData = new int[]{ 9,3,5,6,2,4,8 };
		
		print(tempData);
		
		tempData = doChooseSort(tempData);
		System.out.println("----------");
		print(tempData);
	}

	static int[] doChooseSort(int[] src) {
		int len = src.length;
		int temp;
		for (int i = 0; i < len; i++) {
			temp = src[i];
			int j;
			int samllestLocation = i;// 最小数的下标
			for (j = i + 1; j < len; j++) {
				if (src[j] < temp) {
					temp = src[j];// 取出最小值
					samllestLocation = j;// 取出最小值所在下标
				}
			}
			src[samllestLocation] = src[i];
			src[i] = temp;
			 
		}
		
		return src;
	}
	
	static void print(int[] src){
		for(int i = 0; i<src.length; i++){
			System.out.println(src[i]);
		}
		
	}

}
