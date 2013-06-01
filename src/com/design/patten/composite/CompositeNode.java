package com.design.patten.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeNode extends Node {

	private List<Node> children = new ArrayList();

	public CompositeNode(Node... nodes) {

		for (Node n : nodes) {

			children.add(n);

		}

	}

	public int getValue() {

		int result = 0;

		for (Node n : children) {

			result += n.getValue();

		}

		return result;

	}

}
