package com.suanfa.tree.erchapaixushu;

public class BinaryTree {
	private Node root;

	public BinaryTree() {
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * 寻找节点
	 * 
	 * @param node
	 */
	public Node find(int data) {
		if (this.root.getData() == data) {
			return this.root;
		}
		Node current = this.root;
		while (current != null) {
			int temp_data = current.getData();
			// 判断查询方向
			if (temp_data >= data) {// 左子树
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			// 判断是否匹配当前节点
			if (current != null && current.getData() == data) {// 匹配则返回
				return current;
			}
		}
		return null;
	}

	/**
	 * 找到要找的节点的父节点
	 * 
	 * @param data
	 * @return
	 */
	private Node findParent(int data) {
		if (this.root.getData() == data) {
			return this.root;
		}
		Node current = this.root;
		Node parent = null;
		while (current != null) {
			parent = current;
			int temp_data = current.getData();
			// 判断查询方向
			if (temp_data >= data) {// 左子树
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			// 判断是否匹配当前节点
			if (current != null && current.getData() == data) {// 匹配则返回
				return parent;
			}
		}
		return null;
	}

	/**
	 * 删除节点
	 * 
	 * @param node
	 */
	public void delete(Node node) {
		int data = node.getData();
		Node target = find(data);
		if (target == null) {
			System.out.println("节点不存在");
			return;
		}
		// 取得目标节点的父节点
		Node parent = this.findParent(data);
		// 目标节点左孩子
		Node left_temp = target.getLeftChild();
		// 目标节点右孩子
		Node right_temp = target.getRightChild();

		if (target.getLeftChild() != null && target.getRightChild() != null) {// 有两个孩子节点
			// 目标节点直接左孩子
			Node direct_leftChild = left_temp;
			// 目标节点直接左孩子的父节点
			Node direct_leftChild_p = target;
			// 找到目标节点的直接左孩子节点以及记录该孩子节点的父节点
			while (direct_leftChild.getLeftChild() != null) {
				direct_leftChild_p = direct_leftChild;
				direct_leftChild = direct_leftChild.getLeftChild();
			}
			// 执行删除操作
			target = null;
			if (parent.getLeftChild().getData() == data) {
				parent.setLeftChild(direct_leftChild);
			}
			if (parent.getRightChild().getData() == data) {
				parent.setRightChild(direct_leftChild);
			}
			if (direct_leftChild_p.getRightChild() != null) {
				direct_leftChild.setRightChild(direct_leftChild_p
						.getRightChild());
			}
		} else {// 节点是叶子节点或者只有一个子节点的情况
			target = null;
			// 判断被删除的节点是其父节点的哪个孩子
			if (parent.getLeftChild().getData() == data) {// 左孩子
				// 从新给左孩子设值(为了满足有单个孩子的情况,做了左右孩子值是否为空的判断)
				parent.setLeftChild(left_temp == null ? right_temp : left_temp);
			}
			if (parent.getRightChild().getData() == data) {// 右孩子
				// 同上
				parent.setRightChild(right_temp == null ? left_temp
						: right_temp);
			}
		}
	}

	/**
	 * 添加节点
	 * 
	 * @param node
	 */
	public void insert(Node node) {
		if (this.root == null) {// 根节点不存在
			this.root = node;
		} else {
			Node current = this.root;
			while (true) {
				Node temp = null;
				if (current.getData() > node.getData()) {// 左子树
					temp = current.getLeftChild();
					if (temp == null) {
						current.setLeftChild(node);
						return;
					}
				} else {
					temp = current.getRightChild();
					if (temp == null) {
						current.setRightChild(node);
						return;
					}
				}
				current = temp;
			}
		}
	}

	public void print() {
		inorder_traversal(this.root, 1);// 中序遍历的结果是一个有序的序列
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 * @param level
	 */
	private void preorder_traversal(Node node, int level) {// 先序遍历
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(node.getData());
		int lev = level + 1;
		if (node.getLeftChild() != null) {
			preorder_traversal(node.getLeftChild(), lev);
		}
		if (node.getRightChild() != null) {
			inorder_traversal(node.getRightChild(), lev);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 * @param level
	 */
	private void inorder_traversal(Node node, int level) {// 中序遍历
		int lev = level + 1;
		if (node.getLeftChild() != null) {
			inorder_traversal(node.getLeftChild(), lev);
		}
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(node.getData());
		if (node.getRightChild() != null) {
			inorder_traversal(node.getRightChild(), lev);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 * @param level
	 */
	private void postorder_traversal(Node node, int level) {// 后序遍历
		int lev = level + 1;
		if (node.getLeftChild() != null) {
			postorder_traversal(node.getLeftChild(), lev);
		}
		if (node.getRightChild() != null) {
			postorder_traversal(node.getRightChild(), lev);
		}
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(node.getData());
	}

}
