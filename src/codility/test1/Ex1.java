/**
 * 
 */
package codility.test1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author morsi
 *
 */
public class Ex1 {
	public int solution(String S) {
		int numberOfSteps = 0;
		boolean foundZero = false;
		int indexOfFirstOne = 0;
		int stringLenght = S.length();
		
		while(!foundZero && indexOfFirstOne<stringLenght-1) {
		    if(S.charAt(indexOfFirstOne)=='1') {
		    	foundZero=true;
		    }
		    else {
		    	indexOfFirstOne++;
		    }
		}
		if(indexOfFirstOne==stringLenght-1 && S.charAt(indexOfFirstOne)=='0') {
			return 0;
		}
		
		for (int i=stringLenght-1; i>=indexOfFirstOne; i--) {
			if(S.charAt(i)=='0') {
				numberOfSteps++;
			}
			else {
				numberOfSteps++;
				if(i!=indexOfFirstOne) {
					numberOfSteps++;
				}
			}
		}
		return numberOfSteps;
    }
	
	@Test
	public void test() {
		assertEquals(0, solution("0"));
		assertEquals(4, solution("110"));
		assertEquals(7, solution("011100")); 
		assertEquals(0, solution("0000000"));
		assertEquals(1, solution("0000001"));
		assertEquals(1, solution("1"));
		assertEquals(2, solution("10"));
		assertEquals(3, solution("11"));
		assertEquals(26, solution("11110100001001000000"));
		assertEquals(25, solution("1111010000100100000"));
		assertEquals(26, solution("1111010000100100001"));
	}

}
