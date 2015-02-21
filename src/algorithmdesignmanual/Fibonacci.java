package algorithmdesignmanual;

import static org.junit.Assert.*;

import org.junit.Test;

public class Fibonacci {

	@Test
	public void test_recursive() {
		assertEquals(0, fibonacci_recursive(0));
		assertEquals(1, fibonacci_recursive(1));
		assertEquals(1, fibonacci_recursive(2));
		assertEquals(2, fibonacci_recursive(3));
		assertEquals(3, fibonacci_recursive(4));
		assertEquals(5, fibonacci_recursive(5));
		assertEquals(8, fibonacci_recursive(6));
		assertEquals(13, fibonacci_recursive(7));
		assertEquals(21, fibonacci_recursive(8));
		assertEquals(34, fibonacci_recursive(9));
		assertEquals(55, fibonacci_recursive(10));
	}

	public int fibonacci_recursive(int n) {
		if(n<2) {
			return n;
		} else {
			return fibonacci_recursive(n-1)+fibonacci_recursive(n-2);
		}
	}
}
