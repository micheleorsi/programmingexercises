package programmingcodeinterview;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class SolutionFindFirstNonRepeatingCharacter {
	
	@Test
	public void testFirstNonRepeatingChar() {
		String longText = "geeksforgeeksandgeeksquizfor";
		this.firstNonRepeatingChar(longText);
	}
	
	public void firstNonRepeatingChar(String value) {
		Map<Character,Integer> dict = new HashMap<Character,Integer>();
		Queue<Character> queue = new LinkedList<Character>();
		
		for (char c : value.toCharArray()) {
			Integer actualNumber = dict.get(c); 
			if(actualNumber==null || actualNumber == 0) {
				actualNumber = 0; 
				queue.add(c);
			} else if(actualNumber==1) {
				queue.remove(c);
			}
			dict.put(c,actualNumber+1);
			System.out.println("Adding "+c+" ..");
			System.out.println("First non repeating char is '"+queue.peek()+"'");
			System.out.println("(queue: "+Arrays.toString(queue.toArray())+")");
			System.out.println();
		}
	}


}
