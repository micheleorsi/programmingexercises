/**
 * 
 */
package crackingcodinginterview5.chapter8.cap1arrayandstring;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given two strings, write a method to decide if one is a permutation of th eother. 
 * 
 * @author micheleorsi
 *
 */
public class CheckPermutationString1_3 {

	public boolean isPermutation(String string1, String string2) {
		// input validation
		if(string1.length()!=string2.length()) {
			return false;
		}
		int[] nOfChars = new int[256]; // assume ASCII
		// O(256)
		for(int i=0; i<nOfChars.length; i++) {
			nOfChars[i]=0;
		}
		// O(str1 length)
		for(int j=0; j<string1.length(); j++) {
			nOfChars[string1.charAt(j)]=nOfChars[string1.charAt(j)]+1;
		}
		// O(str2 length)
		for(int z=0; z<string2.length(); z++) {
			if(nOfChars[string2.charAt(z)]==0) {
				return false;
			} else {
				nOfChars[string2.charAt(z)]=nOfChars[string2.charAt(z)]-1;
			}
		}
		return true;
	}
	
	@Test
	public void test() {
		assertTrue(this.isPermutation("abcdefg", "efgabcd"));
		assertFalse(this.isPermutation("abcdefg", "fgabcd"));
		assertFalse(this.isPermutation("abcdefg", "eefgabcd"));
	}

}
