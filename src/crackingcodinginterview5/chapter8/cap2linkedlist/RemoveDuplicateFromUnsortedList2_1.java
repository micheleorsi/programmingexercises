/**
 * 
 */
package crackingcodinginterview5.chapter8.cap2linkedlist;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Write code to remove duplicates from an unsorted linked list
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author micheleorsi
 *
 */
public class RemoveDuplicateFromUnsortedList2_1 {

	@Test
	public void test() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(3);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		Node node = n1;
		int count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(7, count);
		
		this.removeDuplicates(n1);
		
		node = n1;
		count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(6, count);
		
	}
	
	@Test
	public void test2() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(3);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		Node node = n1;
		int count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(7, count);
		
		this.removeDuplicates_noBuffer(n1);
		
		node = n1;
		count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		assertEquals(6, count);
		
	}
	
	public void removeDuplicates(Node head) {
		// validate input
		Set<Integer> values = new HashSet<Integer>();
		Node runner = head;
		Node previous = head;

		while(runner!=null) {
			if(values.add(runner.value)==false) {
				// should remove this node
				previous.next = runner.next;
			}
			previous = runner;
			runner = runner.next;
		}
	}
	
	public void removeDuplicates_noBuffer(Node head) {
		// validate input
		Node root = head;
		Node previous = head;
		Node current = head;
		Node runner = head;
		
		while(current!=null) {
			runner = root;
			while(runner!=null) {
				if(runner!=current && runner.value==current.value) {
					previous.next = current.next;
				}
				runner=runner.next;
			}		

			previous = current;
			current = current.next;
		}
	}

	

	
}

class Node {
	public Node next;
	public int value;
	
	public void setNext(Node n) {
		this.next = n;
	}
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
}