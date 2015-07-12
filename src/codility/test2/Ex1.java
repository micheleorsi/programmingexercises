package codility.test2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Ex1 {
	
	public String solution(String S, String T) {
		if(S.equals(T)) {
			return "NOTHING";
		}
		
		int differenceInStringSize = Math.abs(S.length()-T.length());
		// the difference between the two string is more than 1 char
		if(differenceInStringSize>1) {
			return "IMPOSSIBLE";
		} 
		// the difference between the two string is exactly 1 char
		else if(differenceInStringSize==1) {
			
			// count how many times each char is present in String S
			Map<Character, Integer> countCharS = new HashMap<Character, Integer>();
			for (char c: S.toCharArray()) {
				if(countCharS.containsKey(c)) {
					Integer actualValue = countCharS.get(c);
					Integer newValue = Integer.valueOf(actualValue.intValue()+1);
					countCharS.put(c, newValue);
				}
				else {
					Integer newValue = Integer.valueOf(1);
					countCharS.put(c, newValue);
				}
			}
			
			// count how many times each char is present in String T
			Map<Character, Integer> countCharT = new HashMap<Character, Integer>();
			for (char c: T.toCharArray()) {
				if(countCharT.containsKey(c)) {
					Integer actualValue = countCharT.get(c);
					Integer newValue = Integer.valueOf(actualValue.intValue()+1);
					countCharT.put(c, newValue);
				}
				else {
					Integer newValue = Integer.valueOf(1);
					countCharT.put(c, newValue);
				}
			}
			
			// diff number of different char in a string
			int diffCounter = Math.abs(countCharS.entrySet().size()-countCharT.entrySet().size());
			
			// if there is one type of char missing all the values must be the same and the missing one should be 1
			if(diffCounter==1) {
				List<Character> charsPresent = new ArrayList<Character>();
				
				for (Map.Entry<Character, Integer> obj : countCharS.entrySet()) {
					Character actualChar = obj.getKey();
					Integer actualValue = obj.getValue();
					
					if(countCharT.get(actualChar)!=null && !countCharT.get(actualChar).equals(actualValue)) {
						return "IMPOSSIBLE";
					} else if(countCharT.get(actualChar)!=null && countCharT.get(actualChar).equals(actualValue)) {
						countCharT.remove(actualChar);
						charsPresent.add(actualChar);
					}
				}
				
				for (Character character : charsPresent) {
					countCharS.remove(character);
				}
				
				if(countCharT.size()==1) {
					char missingChar = countCharT.keySet().iterator().next();
					if(countCharT.get(missingChar).equals(Integer.valueOf(1))) {
						return "INSERT "+String.valueOf(missingChar);
					}
				} else if(countCharS.size()==1) {
					char missingChar = countCharS.keySet().iterator().next();
					if(countCharS.get(missingChar).equals(Integer.valueOf(1))) {
						return "DELETE "+String.valueOf(missingChar);
					}
				}
				
			}
			// if there is the same chars, we can accept a difference of 1 char
			else if(diffCounter==0) {
				List<Character> charsPresent = new ArrayList<Character>();
				for (Map.Entry<Character, Integer> obj : countCharS.entrySet()) {
					Character actualChar = obj.getKey();
					Integer actualValue = obj.getValue();
					
					if(countCharT.get(actualChar)!=null && countCharT.get(actualChar).equals(actualValue)) {
						countCharT.remove(actualChar);
						charsPresent.add(actualChar);
					}
				}
				
				for (Character character : charsPresent) {
					countCharS.remove(character);
				}
				
				char diffChar = countCharT.keySet().iterator().next();
				if(countCharT.get(diffChar) > countCharS.get(diffChar)) {
					return "INSERT "+String.valueOf(diffChar);
				} else if(countCharS.size()==1) {
					return "DELETE "+String.valueOf(diffChar);
				}
			}
			return "IMPOSSIBLE";
		} 
		// difference in string is 0
		else {
			// check swap
			for(int i=1; i<S.length(); i++) {
				char actualChar = S.charAt(i);
				char prevChar = S.charAt(i-1);
				StringBuilder sb = new StringBuilder();
				if(i>=2) {
					sb.append(S.substring(0,i-1));
				}
				sb.append(actualChar);
				sb.append(prevChar);
				sb.append(S.substring(i+1, S.length()));
				
				
				String swappedString = sb.toString();
				
				if(swappedString.equals(T)) {
					return "SWAP "+String.valueOf(prevChar)+" "+String.valueOf(actualChar);
				}
			}
			return "IMPOSSIBLE";
		}
	}
	
	@Test
	public void test() {
		// NOTHING
		assertEquals("NOTHING", solution("nice", "nice"));
		assertEquals("NOTHING", solution("n", "n"));
		assertEquals("NOTHING", solution("michele", "michele"));
		
		// IMPOSSIBLE
		assertEquals("IMPOSSIBLE", solution("o", "odd"));
		assertEquals("IMPOSSIBLE", solution("azr", "o"));
		assertEquals("IMPOSSIBLE", solution("abcdefghlabcdefghlabcdefghlabcdefghlabcdefghlabcdefghlabcdefghlabcdefghlabcdefghlabcdefghl", "o"));
		
		// INSERT
		assertEquals("INSERT e", solution("nice", "niece"));
		assertEquals("INSERT i", solution("nice", "niice"));
		assertEquals("INSERT x", solution("nice", "nicex"));
		assertEquals("IMPOSSIBLE", solution("nice", "ccccc"));
		assertEquals("IMPOSSIBLE", solution("nice", "niccc"));
		assertEquals("IMPOSSIBLE", solution("nice", "ncccc"));
		assertEquals("IMPOSSIBLE", solution("nice", "nieee"));
		
		// DELETE
		assertEquals("DELETE e", solution("niece", "nice"));
		assertEquals("DELETE i", solution("niice", "nice"));
		assertEquals("DELETE x", solution("nicex", "nice"));
		assertEquals("IMPOSSIBLE", solution("ccccc", "nice"));
		assertEquals("IMPOSSIBLE", solution("niccc", "nice"));
		assertEquals("IMPOSSIBLE", solution("ncccc", "nice"));
		assertEquals("IMPOSSIBLE", solution("nieee", "nice"));
		
		// SWAP
//		assertEquals("SWAP o r", solution("form", "from"));
		assertEquals("SWAP r m", solution("form", "fomr"));
		assertEquals("SWAP l e", solution("michele", "micheel"));
		assertEquals("SWAP m i", solution("michele", "imchele"));
		
	}

}
