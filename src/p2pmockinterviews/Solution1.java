package p2pmockinterviews;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * PROBLEM 1:
 * we have a tree 
 * 1) we want to return the number of node at a specific level
 * 2) we want to return all the number of node UNTIL that level
 * 
 * 
 * @author micheleorsi
 *
 */
public class Solution1 {

	@Test
	public void test() {
		Node node0 = new Node(0); // root
		Node node1 = new Node(1); // level 1 left
		Node node2 = new Node(2); // level 1 right
		Node node3 = new Node(3); // level 2 
		Node node4 = new Node(4); // level 2
		Node node5 = new Node(5); // level 2
		Node node6 = new Node(6); // level 2
		
		// build node0 
		node0.right = node1;
		node0.left = node2;
		
		// build node
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		assertEquals(4, this.returnNumberOfNode(node0, 2));
		assertEquals(2, this.returnNumberOfNode(node0, 1));
		assertEquals(1, this.returnNumberOfNode(node0, 0));
		
		assertEquals(7, this.howManyNodes_2(node0, 2));
		assertEquals(3, this.howManyNodes_2(node0, 1));
		assertEquals(1, this.howManyNodes_2(node0, 0));
	}
	
	public int returnNumberOfNode(Node n, int level) {
		// validation of input ..
		if(level ==0) {
			return 1;
		}
		else {
			return returnNumberOfNode(n.right, level-1)+returnNumberOfNode(n.left, level-1);
		}
	}
	
	public int howManyNodes_2(Node n, int level) {
		// validation of input ..
		if(level ==0) {
			return 1;
		}
		else {
			return 1+howManyNodes_2(n.right, level-1)+howManyNodes_2(n.left, level-1);
		}
	}
}


class Node {
	public Node right;
	public Node left;
	public int value;
	
	public Node(int value) {
		super();
		this.value = value;
	}
}

