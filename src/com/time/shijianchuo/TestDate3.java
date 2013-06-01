package com.time.shijianchuo;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class TestDate3 {
	
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sDateSuffix = dateformat.format(date);
		System.out.println("date = "+ sDateSuffix);

	}
}