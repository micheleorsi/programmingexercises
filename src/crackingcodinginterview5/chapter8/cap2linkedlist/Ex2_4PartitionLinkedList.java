package crackingcodinginterview5.chapter8.cap2linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than 
 * or equal to x
 * 
 * @author micheleorsi
 *
 */
public class Ex2_4PartitionLinkedList {

	@Test
	public void test() {
		Node n1 = new Node(5);
		Node n2 = new Node(6);
		Node n3 = new Node(2);
		Node n4 = new Node(4);
		Node n5 = new Node(3);
		Node n6 = new Node(8);
		Node n7 = new Node(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		System.out.println("main1");
		this.printAll(n1);
		
		System.out.println();
		this.partition(n1,5);
		System.out.println();
		System.out.println("main2");
		this.printAll(n3);
	}
	
	public void printAll(Node n) {
		Node actual = n;
		while(actual!=null) {
			System.out.println(actual.value);
			actual = actual.next;
		}
	}
	
	public void partition(Node n, int val) {
		Node lessFirst = null;
		Node lessActual = null;
		Node biggerFirst = null;
		Node biggerActual = null;

		Node actual = n;
		while(actual!=null) {
			System.out.println();
			System.out.println("actual: "+actual.value);
			if(actual.value<=val) {
				if(lessFirst == null) {
					lessFirst = actual;
				} else {
					
					
//					lessFirst = lessActual;
//					lessActual = actual;
//					lessFirst.next = lessActual;
				}
			} else {
				if(biggerFirst ==null) {
					biggerFirst = actual;
				} else {
					biggerActual = biggerFirst;
					biggerFirst = actual;
					biggerActual.next = biggerFirst;
				}
			}
			actual = actual.next;
			
			System.out.println("partition less");
			this.printAll(lessFirst);
			System.out.println("partition bigger");
			this.printAll(biggerActual);
		}
		
		lessActual.next = biggerActual;
		biggerFirst.next=null;
	}

}
