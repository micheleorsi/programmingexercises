package coderbyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctList {
	

	int DistinctList(int[] arr) { 
		int duplicates = 0;
		Set<Integer> buffer = new HashSet<Integer>();
		for(int number: arr) {
			if(buffer.contains(Integer.valueOf(number))) {
				duplicates++;
			} else {
				buffer.add(Integer.valueOf(number));
			}
		}
	    return duplicates;
	  } 
	
	
	
	public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    DistinctList c = new DistinctList();
//	    System.out.print(c.NumberEncoding(s.nextLine())); 
	}
	
	@Test
	public void test() {
		assertEquals(2,DistinctList(new int[] {1, 2, 2, 2, 3}));
		assertEquals(3,DistinctList(new int[] {0,-2,-2,5,5,5}));
		assertEquals(0,DistinctList(new int[] {100,2,101,4}));
		
	}

}
