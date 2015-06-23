package coderbyte;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberEncoding {
	

	String NumberEncoding(String str) { 
		Map<Character,Integer> mapper = new HashMap<Character, Integer>();
		mapper.put('a', 1);
		mapper.put('b', 2);
		mapper.put('c', 3);
		mapper.put('d', 4);
		mapper.put('e', 5);
		mapper.put('f', 6);
		mapper.put('g', 7);
		mapper.put('h', 8);
		mapper.put('i', 9);
		mapper.put('j', 10);
		mapper.put('k', 11);
		mapper.put('l', 12);
		mapper.put('m', 13);
		mapper.put('n', 14);
		mapper.put('o', 15);
		mapper.put('p', 16);
		mapper.put('q', 17);
		mapper.put('r', 18);
		mapper.put('s', 19);
		mapper.put('t', 20);
		mapper.put('u', 21);
		mapper.put('v', 22);
		mapper.put('w', 23);
		mapper.put('x', 24);
		mapper.put('y', 25);
		mapper.put('z', 26);
		
		StringBuffer strReturn = new StringBuffer();
		
		for(char character: str.toCharArray()) {
			Integer index = mapper.get(character);
			if(index == null) {
				strReturn.append(character);
			} else {
				strReturn.append(index);
			}
			
		}
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
	       
	    return strReturn.toString();
	    
	  }
	
	
	
	public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    NumberEncoding c = new NumberEncoding();
	    System.out.print(c.NumberEncoding(s.nextLine())); 
	}
	
	@Test
	public void test() {
		assertEquals("1653 1#!",NumberEncoding("af5c a#!"));
		assertEquals("85121215 45",NumberEncoding("hello 45"));
		assertEquals("10110-1",NumberEncoding("jaj-a"));
		
	}

}
