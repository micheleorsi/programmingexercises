/**
 * 
 */
package lucainterviews;

import org.junit.Test;

/**
 * Invert linked list iteratively and recursively
 * 
 * @author micheleorsi
 *
 */


public class SolutionInvertList {
	
	@Test
	public void testIterative() {
		Node node6 = new Node(6,null); 
		Node node5 = new Node(5,node6); 
		Node node4 = new Node(4,node5); 
		Node node3 = new Node(3,node4);  
		Node node2 = new Node(2,node3); 
		Node node1 = new Node(1,node2); 
		Node node0 = new Node(0,node1); 
		
		
		Node actualNode = node0;
		while(actualNode!=null) {
			actualNode = actualNode.next;
		}
		
		this.invertListIterative(node0);
		System.out.println("iterative");
		actualNode = node6;
		while(actualNode!=null) {
			System.out.println(actualNode.value);
			actualNode = actualNode.next;
		}
	}
	
	// iterative
	public void invertListIterative(Node a) {
		// check edge-case (a null)

		Node previous = null;
		Node actualNode = a;
		Node nextNode = null;

		while(actualNode!=null) {
			nextNode = actualNode.next;
			actualNode.next = previous;
			previous = actualNode;
			actualNode = nextNode;
		}

	}
	
	@Test
	public void testRecursive() {
		Node node6 = new Node(6,null); 
		Node node5 = new Node(5,node6); 
		Node node4 = new Node(4,node5); 
		Node node3 = new Node(3,node4);  
		Node node2 = new Node(2,node3); 
		Node node1 = new Node(1,node2); 
		Node node0 = new Node(0,node1); 
		
		
		Node actualNode = node0;
		while(actualNode!=null) {
			actualNode = actualNode.next;
		}
		
		this.invertListRecursive(node0);
		System.out.println();
		System.out.println("recursive");
		actualNode = node6;
		while(actualNode!=null) {
			System.out.println(actualNode.value);
			actualNode = actualNode.next;
		}
	}
	
	public void invertListRecursive(Node a) {
		invert(a.next, a);
		a.next=null;
	}

	public void invert(Node actual, Node previous) {
		if(actual.next==null) {
			actual.next=previous;
			return;
		} else {
			invert(actual.next, actual);
			actual.next = previous;
		}
	}
}

class Node {
	public Node next = null;
	public int value;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}

