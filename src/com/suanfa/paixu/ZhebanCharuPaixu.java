package com.suanfa.paixu;

public class ZhebanCharuPaixu {

	public static void main(String[] args) {
		// 待排序的数组
		int[] array = { 1, 0, 5, 3, 9, 10, 6, 7 };
		
		binaryInsertSort(array);
		
		// 显示排序后的结果
		System.out.print("排序后： ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "->");
		}

	}

	private static void binaryInsertSort(int[] array) {
		if(array.length == 0){
			return;
		}
		
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int low = 0;
			int high = i - 1;
			
			while (low <= high) {
				// int mid = (high - low) / 2 + low; 
				// 下面这样可能会有整型溢出的问题
				int mid = (low + high) / 2;  
				
				if (temp < array[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			
			// 下面的for循环中，有人用 j > mid; 还有人用 j >= high + 1，这个还需要再看看
			for (int j = i; j >= low + 1; j--) {
				array[j] = array[j - 1];
			}
			
			array[low] = temp;  // 此处用 array[high+1] = temp; 也可

		}
	}

}
