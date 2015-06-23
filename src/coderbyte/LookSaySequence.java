package coderbyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class LookSaySequence {
	

	int LookSaySequence(int num) { 
		  
	    String numString = Integer.toString(num);
	    if(numString.length()==1) {
	    	return Integer.valueOf("1"+numString);
	    }
	    int count = 1;
	    boolean lastSequence = false;
	    
	    StringBuffer returnNumber = new StringBuffer();
	    char actualChar = numString.charAt(0);
	    for(int i=0; i<numString.length()-1; i++) {
	    	actualChar = numString.charAt(i);

	    	if(	actualChar==numString.charAt(i+1)) {
	    		count++;
	    		lastSequence = true;
	    	} else {
	    		returnNumber.append(count+""+actualChar);
	    		count = 1;
	    		lastSequence = false;
	    	}
	    }
	    if(lastSequence) {
	    	returnNumber.append(count+""+actualChar);
	    } else {
	    	returnNumber.append("1"+numString.charAt(numString.length()-1));
	    }
	    return Integer.valueOf(returnNumber.toString()).intValue();
	    
	  }
	
	
	
	public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    LookSaySequence c = new LookSaySequence();
//	    System.out.print(c.NumberEncoding(s.nextLine())); 
	}
	
	@Test
	public void test() {
		assertEquals(11,LookSaySequence(1));
		assertEquals(21,LookSaySequence(11));
		assertEquals(1211,LookSaySequence(21));
		assertEquals(111221,LookSaySequence(1211));
		assertEquals(121426,LookSaySequence(2466));
		
	}

}
