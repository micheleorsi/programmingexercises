package coderbyte;

import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExOh {
	

	String ExOh(String str) {
		int countO = 0;
		int countX = 0;
			
		for (char character : str.toCharArray()) {
			switch(character) {
				case 'o': countO++; break;
				case 'x': countX++; break;
			}
		}
		if(countO==countX) {
			return "true";
		} else {
			return "false";
		}
	}
	
	
	
	public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    ExOh c = new ExOh();
	    System.out.print(c.ExOh(s.nextLine())); 
	}
	
	@Test
	public void test() {
		assertEquals("false",ExOh("xooxxxxooxo"));
		assertEquals("true",ExOh("xooxxo"));
		assertEquals("false",ExOh("x"));
		
	}

}
