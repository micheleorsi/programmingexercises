/**
 * 
 */
package hackerrank.sampletest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author micheleorsi
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(Solution.evaluate(inputString));
	}
	
	public static int evaluate(String string) {
        String[] linearEvaluation = string.split("-|\\+");
        
        int result=Solution.doOperations(linearEvaluation[0]);
        int totalLenght=linearEvaluation[0].length();
        for(int i=1; i<linearEvaluation.length; i++) {
        	int tempResult = Solution.doOperations(linearEvaluation[i]);
        	result = Solution.doOperations(""+result+string.charAt(totalLenght)+tempResult);
        	totalLenght+=linearEvaluation[i].length()+1;
        }
		return result;
	}
	
	
	public static int doOperations(String string) {
		String[] numbers = string.split("-|\\+|\\*|\\/");
		String[] operator = string.split("[0-9]");
		List<String> realOperators = new ArrayList<String>();
        for (String string2 : operator) {
			if(!string2.isEmpty()) {
				realOperators.add(string2);
			}
		}
        if(realOperators.size()==0) {
        	return Integer.parseInt(numbers[0]);
        } else if(realOperators.size()==1) {
        	Integer int1 = Integer.parseInt(numbers[0]);
    		Integer int2 = Integer.parseInt(numbers[1]);
    		int result = 0;
    		switch (realOperators.get(0)) {
    			case "+": result =  int1+int2; break;
    			case "-": result = int1-int2; break;
    			case "*": result = int1*int2; break;
    			case "/": result = int1/int2; break;
    			default:
    				return -1;
    		}
    		return result;
        }
        else {
        	String firstOperation = numbers[0]+realOperators.get(0)+numbers[1];
        	String restOfTheString = string.substring(firstOperation.length(),string.length());
        	return Solution.doOperations(
        			Solution.doOperations(firstOperation)+
        			restOfTheString);        	
        }		
	}
	
	@Test
	public void test1() {
		assertEquals(6, Solution.doOperations("6"));
		assertEquals(2, Solution.doOperations("2"));
		assertEquals(200, Solution.doOperations("200"));
		assertEquals(6, Solution.doOperations("4+2"));
		assertEquals(2, Solution.doOperations("4/2"));
		assertEquals(10*2, Solution.doOperations("10*2"));
		assertEquals(200-120, Solution.doOperations("200-120"));
		assertEquals(40*3/2, Solution.doOperations("40*3/2"));
		assertEquals(10/5*10*20/10, Solution.doOperations("10/5*10*20/10"));
		assertEquals(14*2/7*10*20, Solution.doOperations("14*2/7*10*20"));
		assertEquals(14+2+7-10+20, Solution.doOperations("14+2+7-10+20"));
	}
	
	@Test
	public void test2() {
		assertEquals(185, Solution.evaluate("10+40*3/2+10*44/4+5"));
		assertEquals(1375, Solution.evaluate("1100-40*4/2+100*14/4+5"));
	}

}
