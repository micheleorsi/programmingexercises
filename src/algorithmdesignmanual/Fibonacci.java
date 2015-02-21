package algorithmdesignmanual;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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
	
	Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public Fibonacci() {
		cache.put(0, 0);
		cache.put(1,1);
	}
	
	@Test
	public void test_caching() {
		assertEquals(0, fibonacci_caching(0));
		assertEquals(1, fibonacci_caching(1));
		assertEquals(1, fibonacci_caching(2));
		assertEquals(2, fibonacci_caching(3));
		assertEquals(3, fibonacci_caching(4));
		assertEquals(5, fibonacci_caching(5));
		assertEquals(8, fibonacci_caching(6));
		assertEquals(13, fibonacci_caching(7));
		assertEquals(21, fibonacci_caching(8));
		assertEquals(34, fibonacci_caching(9));
		assertEquals(55, fibonacci_caching(10));
	}

	public int fibonacci_caching(int n) {
		if(cache.containsKey(n)) {
			return cache.get(n);
		} else {
			int temp = fibonacci_caching(n-1)+fibonacci_caching(n-2);
			cache.put(n,temp);
			return temp;
		}
	}

	@Test
	public void test_optimal() {
		assertEquals(0, fibonacci_optimal(0));
		assertEquals(1, fibonacci_optimal(1));
		assertEquals(1, fibonacci_optimal(2));
		assertEquals(2, fibonacci_optimal(3));
		assertEquals(3, fibonacci_optimal(4));
		assertEquals(5, fibonacci_optimal(5));
		assertEquals(8, fibonacci_optimal(6));
		assertEquals(13, fibonacci_optimal(7));
		assertEquals(21, fibonacci_optimal(8));
		assertEquals(34, fibonacci_optimal(9));
		assertEquals(55, fibonacci_optimal(10));
	}

	public int fibonacci_optimal(int n) {
		if(n<2) {
			return n;
		}
		int previous = 1;
		int previousPrevious = 0;
		int actual = 0;
		for(int i=1; i<n; i++) {
			actual = previous + previousPrevious;
			previousPrevious = previous;
			previous = actual;
		}
		return actual;
	}
}
