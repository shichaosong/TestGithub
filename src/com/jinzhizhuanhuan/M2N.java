package com.jinzhizhuanhuan;

/**
 * 功能：将一个数从M进制转换成N进制
 * MValue：M进制数的字符串表示方法 
 * Shang：保存中间运算结果 
 * M：M进制 N：N进制
 */
public class M2N {
	// 在这里对输入赋值
	public static String MValue = "15";
	public static String Shang = null;
	public static int M = 10;
	public static int N = 2;

	public static void main(String[] args) {
		String nValue = "";
		Shang = MValue;
		while (Shang.length() > 0) {
			nValue = qiuyu(Shang) + nValue;
		}
		System.out.println(nValue);
	}

	/**
	 * 功能：对给定的M进制字符串对n求余。
	 * 
	 * @param MTempValue
	 * @param m
	 * @param n
	 * @return
	 */
	public static String qiuyu(String MTempValue) {
		Shang = "";
		int temp = 0;
		while (MTempValue.length() > 0) {
			int t = getIntFromStr(MTempValue.substring(0, 1));
			MTempValue = MTempValue.substring(1);
			temp = temp * M + t;
			Shang += getStrFromInt(temp / N);
			temp = temp % N;
		}
		while (Shang.length() > 0 && Shang.charAt(0) == '0') {
			Shang = Shang.substring(1);
		}
		return getStrFromInt(temp);
	}

	public static int getIntFromStr(String str) {
		return str.charAt(0) <= '9' && str.charAt(0) >= '0' ? str.charAt(0) - '0'
				: str.charAt(0) - 'a' + 10;
	}

	public static String getStrFromInt(int value) {
		String result = null;
		if (value >= 0 && value <= 9)
			result = String.valueOf((char) ('0' + value));
		else if (value > 9 && value < 36) {
			result = String.valueOf((char) ('a' + value - 10));
		} else {
			result = "-1";// 出错误了
		}
		return result;
	}
	
	
}
