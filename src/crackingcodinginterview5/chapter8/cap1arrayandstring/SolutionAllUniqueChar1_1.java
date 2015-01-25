/**
 * 
 */
package crackingcodinginterview5.chapter8.cap1arrayandstring;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structure?
 * 
 * @author micheleorsi
 *
 */
public class SolutionAllUniqueChar1_1 {

	
	public boolean allUnique_withArray(String string) {
		// input validation .. 
		boolean[] str_value = new boolean[256]; // assume ASCII
		for(int i=0; i<256; i++) {
			str_value[i]=false;
		}
		for(int i=0; i<string.length(); i++) {
			if(str_value[string.charAt(i)]==true) {
				return false;
			} else {
				str_value[string.charAt(i)]=true;
			}
		}
		return true;
	}
	
	/**
	 * time: O(n), length of string
	 * space: O(number of chars)
	 * 
	 * @param string
	 * @return
	 */
	public boolean allUnique(String string) {
		// input validation .. 
		char[] str = string.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<str.length; i++) {
			if(set.add(str[i])==false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean allUnique_withoutAdditionalSpace(String string) {
		// input validation .. 
		char[] str = string.toCharArray();
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<str.length; j++) {
				if(j!=i && str[j]==str[i]) {
					return false;
				}
			}
			
		}
		return true;
	}

	@Test
	public void test() {
		assertFalse(this.allUnique("abcdefghijkla"));
		assertTrue(this.allUnique("abcdefghijkl"));
		
		assertFalse(this.allUnique_withoutAdditionalSpace("abcdefghijkla"));
		assertTrue(this.allUnique_withoutAdditionalSpace("abcdefghijkl"));
		
		assertFalse(this.allUnique_withArray("abcdefghijkla"));
		assertTrue(this.allUnique_withArray("abcdefghijkl"));
	}

}
