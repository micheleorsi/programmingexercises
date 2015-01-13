package google;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 1) write a function that calculates power to n of a number
 * 2) let's assume you cannot use the Math.pow()
 * 3) time/space complexity
 * 4) how would you deal with stack overflow? how you prevent it?
 * 5) can we do better?
 * 6) space/time complexity?
 * 7) java integer is 32 bits and we have a log function, can we say something more about complexity?
 * 
 * @author micheleorsi
 *
 */
public class Solution {

	@Test
	public void test() {
		assertEquals(1, this.powerToN(4, 0));
		assertEquals(8, this.powerToN(2, 3));
		assertEquals(25, this.powerToN(5, 2));
		
		// power to n
		assertEquals(1, this.powerToNConstraint(4, 0));
		assertEquals(8, this.powerToNConstraint(2, 3));
		assertEquals(64, this.powerToNConstraint(2, 6));
		assertEquals(25, this.powerToNConstraint(5, 2));
		assertEquals(1073741824, this.powerToNConstraint(2, 30));
		try {
			assertEquals(10, this.powerToNConstraint(2, 32));
			fail();
		} catch (RuntimeException r) {
			assertEquals("overflow", r.getMessage());
		}
		
		// power to n recursive
		assertEquals(1, this.powerToNRecursive(4, 0));
		assertEquals(8, this.powerToNRecursive(2, 3));
		assertEquals(64, this.powerToNRecursive(2, 6));
		assertEquals(25, this.powerToNRecursive(5, 2));
		assertEquals(1073741824, this.powerToNRecursive(2, 30));
		try {
			assertEquals(10, this.powerToNRecursive(2, 32));
			fail();
		} catch (RuntimeException r) {
			assertEquals("overflow", r.getMessage());
		}
		
		// power to n opt
		assertEquals(1, this.powerToNOpt(4, 0));
		assertEquals(8, this.powerToNOpt(2, 3));
		assertEquals(64, this.powerToNOpt(2, 6));
		assertEquals(25, this.powerToNOpt(5, 2));
		assertEquals(1073741824, this.powerToNOpt(2, 30));
		try {
			assertEquals(10, this.powerToNOpt(2, 32));
			fail();
		} catch (RuntimeException r) {
			assertEquals("overflow", r.getMessage());
		}
		
	}
	
	public int powerToN(int x, int y) {
		return Double.valueOf(Math.pow(x, y)).intValue();
	}

	// time: O(n) -> O(y)
	// space O(1)
	public int powerToNConstraint(int x, int y) {
		int result = 1;
		for(int i=1;i<=y;i++) {
			if((Integer.MAX_VALUE/result)<x) {
				throw new RuntimeException("overflow");
			}
			result*=x;
		}
		return result;
	}
	// time O(n) -> O(y)
	// space O(n) -> O(y)
	public int powerToNRecursive(int x, int y) {
		if(y==0) {
			return 1;
		} else if(y==1) {
			return x;
		} else {
			int tempPower = powerToN(x, y-1);
			if((Integer.MAX_VALUE/tempPower)<x) {
				throw new RuntimeException("overflow");
			}
			return x*tempPower;
		}
	}
	// time: O(logn) -> O(logy)
	// space: O(logn)
	public int powerToNOpt(int x, int y) {
		if(y==0) {
			return 1;
		} else if(y==1) {
			return x;
		} else if(y%2==0) {
			int result = powerToNOpt(x, y/2);
			if((Integer.MAX_VALUE/result)<result) {
				throw new RuntimeException("overflow");
			}
			return result*result;
		} else {
			int tempPower = powerToNOpt(x, y-1);
			if((Integer.MAX_VALUE/tempPower)<x) {
				throw new RuntimeException("overflow");
			}
			return x*tempPower;
		}
	}
	
}
