package com.design.patten.prototype;

public class TestClonealbe {

	public static void main(String[] args) throws Exception {

		Father f = new Father();
		User u1 = new User("123456", f);
		User u2 = (User) u1.clone();

		System.out.println(u1 == u2); 
		System.out.println(u1.equals(u2));
		System.out.println(u1.f == u2.f);

	}

}


