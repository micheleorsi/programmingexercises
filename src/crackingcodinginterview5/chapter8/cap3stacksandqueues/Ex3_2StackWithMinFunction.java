package crackingcodinginterview5.chapter8.cap3stacksandqueues;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time
 * 
 * @author micheleorsi
 *
 */
public class Ex3_2StackWithMinFunction {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

//class Stack {
//	Stack min = new Stack();
//
//	public void push(int value) {
//		super.push();
//		if(min.peek()<value) {
//			min.push(min.peek())
//		} else {
//			min.push(value);
//		}
//	}
//
//	public int min() {
//	}
//
//	public int pop() {
//		super.pop();
//		min.pop();			
//	}
//}