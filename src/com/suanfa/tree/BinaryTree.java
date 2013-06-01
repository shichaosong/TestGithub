package com.suanfa.tree;

import java.util.ArrayList;

/**
 * 节点类 还可以定义成泛型：Node<E>
 */
class Node {
	public Node left;
	public Node right;
	public int data;

	Node(int newData) {
		left = null;
		right = null;
		data = newData;
	}

}

public class BinaryTree {

	public static void main(String[] args) {

		BinaryTree biTree = new BinaryTree();
		int[] data = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 };

		biTree.buildTree(data);

		// biTree.printTree(root);

		preOrder(root);
//		inOrder(root);
//		postOrder(root);
//		layerOrder(root);
	}

	private static Node root;

	/**
	 * 创建一个空的二叉树
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * 将数值插入到二叉树中，比当前结点小或等于当前结点的插在当前结点的左侧，比当前结点大的数插在当前结点的右侧，每次从根结点开始递归比较
	 * 
	 * @param node
	 *            当前的结点，就是根结点，只是每次根结点的左右子孙更新
	 * @param data
	 *            要插入的数值
	 * @return 新排好的二叉树
	 */

	private Node insert(Node node, int data) {

		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return node;
	}

	/**
	 * 将数值输入构建二叉树
	 * 
	 * @param data
	 *            要输入的数值
	 */

	public void buildTree(int[] data) {
		for (int i = 0; i < data.length; i++) {
			insert(root, data[i]);
		}
	}

	/**
	 * 从根结点开始遍历，从树的最高层叶子结点开始输出，从左至右
	 *	<pre> 
	 *	这个相当于中序遍历
	 * @param node 当前的结点
	 */
	private static void printTree(Node node) {
		if (node == null) {
			return;
		}

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);

	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + "-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inOrder(Node root) {

		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "--");
			inOrder(root.right);
		}
	}

	/**
	 * 后续遍历
	 * 
	 * @param root
	 */
	public static void postOrder(Node root) {

		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + "---");
		}
	}

	/**
	 * 层序遍历
	 * 
	 * @param root
	 */
	public static void layerOrder(Node root) {
		// 创建队列
		ArrayList<Node> q = new ArrayList<Node>();
		q.add(root);

		while (q.size() > 0) {
			// 出列
			root = (Node) q.get(0);
			q.remove(0);
			
			// 访问队列头部节点
			System.out.print(root.data + "→");
			if (root.left != null)
				// 将节点的左子节点保存至队列
				q.add(root.left);
			if (root.right != null)
				// 将节点的右子节点保存至队列
				q.add(root.right);
		}
	}

}
