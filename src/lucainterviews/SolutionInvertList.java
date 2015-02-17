/**
 * 
 */
package lucainterviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Invert linked list iteratively and recursively
 * 
 * @author micheleorsi
 *
 */


public class SolutionInvertList {
	
	@Test
	public void test() {
		Node node6 = new Node(6,null); 
		Node node5 = new Node(5,node6); 
		Node node4 = new Node(4,node5); 
		Node node3 = new Node(3,node4);  
		Node node2 = new Node(2,node3); 
		Node node1 = new Node(1,node2); 
		Node node0 = new Node(0,node1); 
		
		
		Node actualNode = node0;
		while(actualNode!=null) {
//			System.out.println(actualNode.value);
			actualNode = actualNode.next;
		}
		
		this.invertList(node0);
		
		actualNode = node6;
		while(actualNode!=null) {
			System.out.println(actualNode.value);
			actualNode = actualNode.next;
		}
		
	}
	
	// iterative
	public void invertList(Node a) {
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

}

class Node {
	public Node next = null;
	public int value;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
}

