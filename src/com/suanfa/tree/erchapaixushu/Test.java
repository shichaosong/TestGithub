package com.suanfa.tree.erchapaixushu;

public class Test {

	public static void main(String[] args) {

		int[] a = { 23, 12, 43, 2, 87, 54 };

		BinaryTree tree = new BinaryTree();

		for (int i = 0; i < a.length; i++) {
			Node node = new Node();
			node.setData(a[i]);
			tree.insert(node);
		}

		tree.print();

	}

}
