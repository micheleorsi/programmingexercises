/**
 * 
 */
package crackingcodinginterview5.chapter8.cap2linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
 * 
 * @author micheleorsi
 *
 */
public class DeleteANodeInTheMiddle2_3 {

	@Test
	public void test() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		Node node = n1;
		int count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(4, count);

		this.removeNode(n3);
		
		node = n1;
		count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(3, count);
	}

	public void removeNode(Node n) {
		Node actual = n;
		actual.value = actual.next.value;
		actual.next = actual.next.next;
	}


}
