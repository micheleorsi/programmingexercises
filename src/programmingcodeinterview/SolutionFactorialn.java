/**
 * 
 */
package programmingcodeinterview;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.*;

/**
 * @author micheleorsi
 *
 */
public class SolutionFactorialn {
	
	@Test
	public void testFactorial() {
		assertEquals(6, this.factorialN(3));
		assertEquals(6, this.factorialN_recursive(3));
		
		assertEquals(24, this.factorialN(4));
		assertEquals(24, this.factorialN_recursive(4));
		
		assertEquals(120, this.factorialN(5));
		assertEquals(120, this.factorialN_recursive(5));
		
		assertEquals(3628800, this.factorialN_recursive(10));
		System.out.println("normal "+this.factorialN_recursive(13));
	}
	@Test
	public void testFactorial_optim() {
		assertEquals(6, this.factN_tailOptimization(BigInteger.valueOf(3), BigInteger.ONE).intValue());
		assertEquals(24, this.factN_tailOptimization(BigInteger.valueOf(4), BigInteger.ONE).intValue());
		assertEquals(120, this.factN_tailOptimization(BigInteger.valueOf(5), BigInteger.ONE).intValue());
		assertEquals(3628800, this.factN_tailOptimization(BigInteger.valueOf(10), BigInteger.ONE).intValue());
		System.out.println("optim "+this.factN_tailOptimization(BigInteger.valueOf(13), BigInteger.ONE));
	}
	
	public BigInteger factN_tailOptimization(BigInteger n, BigInteger acc) {
		if(n==BigInteger.ZERO) {
			return acc;
		} else {
			return factN_tailOptimization(n.subtract(BigInteger.ONE), n.multiply(acc));
		}
	}

	public int factorialN(int input) {
		int result = 1;
		if(input<0) {
			return -1;
		}
		for(int i=1; i<=input; i++) {
			result = result * i;
		}
		return result;
	}
	
	public int factorialN_recursive(int input) {
		int result = 1;
		if(input<0) {
			return -1;
		}
		if(input==1) {
			return 1;
		} else {
			return input * factorialN_recursive(input-1);
		}
	}
}
