/**
 * 
 */
package interviewcake;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * https://www.interviewcake.com/question/coin
 * 
 * @author micheleorsi
 *
 */
public class SolutionCoin {

	@Test
	public void testCase() {
		assertEquals(4, SolutionCoin.combinationsChange(4, new int[]{1,2,3}));
		
	}
	
	public static int combinationsChange(int amount, int[] denom){
		if(amount==0){
			return 1;
		}
		if(amount<0){
			return 0;
	}

	if(denom==null){
	return 0;
	}
	int current_coin = denom[0];
	int[] denoms_left = Arrays.copyOfRange(denom,1,denom.length);
	int numPossib = 0;
	while(amount >= 0){
		numPossib +=  combinationsChange(amount, denoms_left);
		amount -= current_coin;
	}
	return numPossib;

	}


}
