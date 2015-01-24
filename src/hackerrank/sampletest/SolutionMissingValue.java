/**
 * 
 */
package hackerrank.sampletest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * find the missing value in an aritmetic progression
 * 
 * @author micheleorsi
 *
 */
public class SolutionMissingValue {
	
	public static int missingValue(List<Integer> list) {
		Map<Integer,Integer> diff = new HashMap<Integer, Integer>();
		int previousNumber = list.get(0);
		for(int i=1; i<list.size(); i++) {
			int actualNumber = list.get(i);
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
		previousNumber = list.get(0);
		for(int i=1; i<list.size(); i++) {
			int actualNumber = list.get(i);
			if((actualNumber-previousNumber)!=rightDiff) {
				return previousNumber+rightDiff;
			} else {
				previousNumber = actualNumber;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		inputString = sc.nextLine();
		StringTokenizer st = new StringTokenizer(inputString);
		List<Integer> listOfInt = new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			listOfInt.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(SolutionMissingValue.missingValue(listOfInt));
	}

}
