/**
 * 
 */
package crackingcodinginterview5.chapter6;

import org.junit.Test;

/**
 * Design an algorithm to print all permutations of a string. 
 * For simplicity, assume all characters areunique
 * 
 * @author micheleorsi
 *
 */
public class SolutionStringPermutation {

	@Test
	public void test() {
		this.permutation("abcd");
	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	/**
	 * the call stack is:
	 * - abcd
	 * --a,bcd
	 * ---ab,cd
	 * ----abc,d
	 * -----abcd (return)
	 * ----abd,c
	 * -----abdc (return)
	 * ---ac,bd
	 * ----acb,d
	 * -----acbd (return)
	 * ----acd,b
	 * -----acdb (return)
	 * ...
	 * 
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str) {
//		System.out.print("1st "+prefix);
//    	System.out.print(", 2nd "+str);
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println("|"+prefix+"|");
	    }
	    else {
	        for (int i = 0; i < n; i++){
	        	permutation(prefix + str.charAt(i), 
	            		str.substring(0, i) + str.substring(i+1, n));
	        }
	            
	    }
	}

}
