package interviewcake;

import org.junit.Test;


/**
 * 
 * https://www.interviewcake.com/question/balanced-binary-tree
 * 
 * Write a function to see if a binary tree is "superbalanced" (a new tree property we just made up).
 * 
 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
 * 
 * @author morsi
 *
 */
public class Ex08_BalancedBinaryTree {
	
	class Node {
		private int value = -1;
		private Node left = null;
		private Node right = null;
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	int minDeep = 100;
	int maxDeep = 100;
	
	public int deep(Node root) {
		// it is a leaf
		if(root.left ==null || root.right ==null) { 
			return 1;
		} else {
			return 1 + deep(root.left);
		}
	}

	@Test
	public void test() {
		
	}
}
