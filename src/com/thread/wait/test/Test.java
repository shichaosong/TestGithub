package com.thread.wait.test;

/**
 * 可以用这个类测试一下
 */
public class Test {
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		// 添加
		dll.add("张曼玉");
		dll.add("钟楚红");
		dll.add("刘嘉玲");
		System.out.println(dll);

		// 添加到最前
		dll.addFirst("林青霞");
		System.out.println(dll);

		// 添加到最后
		dll.addLast("梅艳芳");
		System.out.println(dll);

		// 添加到指定位置
		dll.add(4, "王祖贤");
		System.out.println(dll);

		// 移除最前的
		dll.removeFirst();
		System.out.println(dll);

		// 移除最后的
		dll.removeLast();
		System.out.println(dll);

		// 移除指定位置上的
		dll.remove(2);
		System.out.println(dll);

		// 返回指定位置上的元素
		System.out.println(dll.get(1));

	}
}
