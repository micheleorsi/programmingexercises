package coderbyte;

import static org.junit.Assert.*;

import java.util.*; 
import java.io.*;

import org.junit.Test;

public class PrimeTime {  
	  String PrimeTime(int num) { 		
		for(int i=2; i<num; i++) {
			if((num % i)==0) {
				return "false";
			}
		}
	    return "true";
	    
	  } 
	  
	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    PrimeTime c = new PrimeTime();
//	    System.out.print(c.PrimeTime(s.nextLine())); // I know this is strange, but it's the only it works
	  }   
	 
	  
	 
}



  