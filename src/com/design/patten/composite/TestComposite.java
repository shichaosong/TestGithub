package com.design.patten.composite;

import java.util.*;

public class TestComposite {

	public static void main(String[] args) {

		Node n1 = new LeafNode(3);
		Node n2 = new LeafNode(4);
		Node n3 = new LeafNode(6);
		
		Node n4 = new LeafNode(5);
		Node n5 = new LeafNode(2);
		Node n6 = new LeafNode(9);
		Node n7 = new LeafNode(12);
		
		Node n8 = new LeafNode(7);
		Node n9 = new LeafNode(8);

		Node c1 = new CompositeNode(n1, n2, n3);
		
		Node c4 = new CompositeNode(n8, n9);
		Node c3 = new CompositeNode(n5, c4);

		Node c2 = new CompositeNode(n4, c3);
		Node c5 = new CompositeNode(n6, n7);

		Node root = new CompositeNode(c1, c2, c5);

		System.out.println(root.getValue());

	}

}




