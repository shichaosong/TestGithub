package com.suanfa.paixu;

/**
 * 基数排序2
 * @author Administrator
 *
 */
public class JishuPaixu2 {
	
	public static void sort(int[] number, int d) {
		int k = 0;
		int n = 1;
		int m = 1;
		int[][] temp = new int[number.length][number.length];
		int[] order = new int[number.length];
		while (m <= d) {
			for (int i = 0; i < number.length; i++) {
				int lsd = ((number[i] / n) % 10);
				temp[lsd][order[lsd]] = number[i];
				order[lsd]++;
			}
			
			for (int i = 0; i < d; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						number[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}

	public static void main(String[] args) {
		int[] data = { 73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100 };
		
		JishuPaixu2.sort(data, 10);
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	
}
