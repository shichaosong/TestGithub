package com.time.shijianchuo;

import java.util.*; 
import java.text.*;
// 方法二：用java.util.Calendar类来实现，看下面：
// 以下是利用Calendar类来实现日期时间的，和Date类相比较比较简单
public class TestDate2 { 
   public static void main(String[] args) { 
      
      Calendar ca = Calendar.getInstance();
      int year = ca.get(Calendar.YEAR);	//获取年份
      int month=ca.get(Calendar.MONTH);	//获取月份 
      int day=ca.get(Calendar.DATE);	//获取日
      
      int hour=ca.get(Calendar.HOUR);	//小时 
      int minute=ca.get(Calendar.MINUTE);	//分 
      int second=ca.get(Calendar.SECOND);	//秒
      
      int WeekOfYear = ca.get(Calendar.DAY_OF_WEEK); // 一周的第几天，从周日算作第一天
      
      
      System.out.println("用Calendar.getInstance().getTime()方式显示时间: " + ca.getTime());
      System.out.println("用Calendar获得日期是：" + year +"年"+ month +"月"+ day + "日");
      
      System.out.println("用Calendar获得时间是：" + hour +"时"+ minute +"分"+ second +"秒");
      System.out.println(WeekOfYear);//显示今天是一周的第几天（我做的这个例子正好是周二，故结果显示2，如果你再周6运行，那么显示6）
      
   }

}


