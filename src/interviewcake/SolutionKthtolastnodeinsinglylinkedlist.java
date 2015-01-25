/**
 * 
 */
package interviewcake;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author micheleorsi
 *
 */
public class SolutionKthtolastnodeinsinglylinkedlist {
	
	@Test
	public void testSolution() {
		Node a = new Node("Angel Food");
		Node b = new Node("Bundt");
		Node c = new Node("Cheese"); // 3
		Node d = new Node("Devil's Food"); // 2
		Node e = new Node("Eccles"); // 1

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		assertEquals("Devil's Food", kth_to_last_node_nsquared2(2, a).name);
		assertEquals("Devil's Food", kth_to_last_node_n(2, a).name);
//		assertEquals("Devil's Food", kToLast(2, a).name);
//		assertEquals("Devil's Food", kToLast2(2, a).name);

	}
	
	public Node kth_to_last_node_n(int number, Node node) {
		Node root = node;
		List<Node> list = new ArrayList<Node>(); 
		// O(n)
		do {
			list.add(root); // adding O(1) amortized
			root = root.next;
		} while(root!=null);
		return list.get(list.size()-number); // retrieve O(1)
	}
	
	/**
	 * 
	 * @param number
	 * @param node
	 * @return
	 */
	public Node kth_to_last_node_nsquared2(int number, Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node root = node;

		while(root.next!=null) {
			stack.push(root.next);
			root = root.next;
		}
		
		Node returnNode = null;	
		for(int i=0; i<number; i++) {
			returnNode = stack.pop();
		}
		return returnNode;
	}
}

class Node {

	public Node next = null;
	public String name = null;
	
	public Node(String name) {
		this.name = name;
	}
}