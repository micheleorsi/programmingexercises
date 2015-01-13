/**
 * 
 */
package programmingcodeinterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionFizzBuzz {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
         line = br.readLine();   
        } catch(IOException ex) {}
        int N = Integer.parseInt(line);
        for(int i=1; i<=N; i++) {
		  String toPrint = "";
		  if(i%3==0) {
			toPrint+="Fizz";
		  }
		  if(i%5==0) {
			toPrint+="Buzz";
		  }
		  if(toPrint.isEmpty()) {
			System.out.println(i);
		  } else {
			System.out.println(toPrint);
		  }
        } 
    }
}