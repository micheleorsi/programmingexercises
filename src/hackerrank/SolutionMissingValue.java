/**
 * 
 */
package hackerrank;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

/**
 * find the missing value in an aritmetic progression
 * 
 * @author micheleorsi
 *
 */
public class SolutionMissingValue {
	
	public static int missingValue(int[] list) {
		Map<Integer,Integer> diff = new HashMap<Integer, Integer>();
		int previousNumber = list[0];
		for(int i=1; i<list.length; i++) {
			int actualNumber = list[i];
			Integer totalDiff = 0;
			totalDiff = diff.get(actualNumber-previousNumber);
			if(totalDiff==null) {
				totalDiff = 0;
			}
			diff.put(actualNumber-previousNumber,++totalDiff);
			previousNumber = actualNumber;
		}
		int rightDiff = 0;
		for (Integer integer : diff.keySet()) {
			if(diff.get(integer)!=1) {	
				rightDiff = integer;
			}
		}
		previousNumber = list[0];
		for(int i=1; i<list.length; i++) {
			int actualNumber = list[i];
			if((actualNumber-previousNumber)!=rightDiff) {
				return previousNumber+rightDiff;
			} else {
				previousNumber = actualNumber;
			}
		}
		return -1;
	}
	
	@Test
	public void test() {
		assertEquals(7, SolutionMissingValue.missingValue(new int[] {1,3,5,9,11}));
		assertEquals(21, SolutionMissingValue.missingValue(new int[] {1,11,31,41,51}));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String inputString = sc.nextLine();
		int[] values = new int[n];
		StringTokenizer st = new StringTokenizer(inputString);
		int index = 0;
		while(st.hasMoreTokens()) {
			values[index++]=Integer.parseInt(st.nextToken());
		}
		System.out.println(SolutionMissingValue.missingValue(values));
	}

}
