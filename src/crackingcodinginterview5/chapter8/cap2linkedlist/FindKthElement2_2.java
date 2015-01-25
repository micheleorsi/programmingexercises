/**
 * 
 */
package crackingcodinginterview5.chapter8.cap2linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 * 
 * @author micheleorsi
 *
 */
public class FindKthElement2_2 {

	@Test
	public void test() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		assertEquals(n7, this.getKthElement(n1, 1));
		assertEquals(n6, this.getKthElement(n1, 2));
		assertEquals(n5, this.getKthElement(n1, 3));
	}

	public Node getKthElement(Node head, int elementFromEnd) {
		// input validator
		Node current = head;
		Node runner = head;

		for(int i=0; i<elementFromEnd; i++) {
			runner= runner.next;
		}

		while(runner!=null) {
			current = current.next;
			runner = runner.next;
		}
		
		return current;
		
	}
}
