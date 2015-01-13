package programmingcodeinterview;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.Test;

public class SolutionRansomNote {
	
	@Test
	public void testRansomNote() {
		String ransom = "you will be dying";
		String magazine = "dying bl bla is what you will be doing";
		assertTrue(this.canRansomNote(ransom, magazine));
		
		ransom = "You will be dying";
		magazine = "dying bl bla is what you will be doing";
		assertFalse(this.canRansomNote(ransom, magazine));
	}
	// r ransom
	// m magazine
	public boolean canRansomNote(String ransom, String magazine) {
		StringTokenizer st = new StringTokenizer(ransom);
		Map<String,Integer> dict = new HashMap<String, Integer>();
		// dictionary for ransom note: O(r)
		while(st.hasMoreTokens()) {
			String tempStr = st.nextToken(" ");
			Integer value = dict.get(tempStr);
			if(value == null) {
				value = 0;
			}
			dict.put(tempStr, ++value);
		}
		st = new StringTokenizer(magazine);
		// average/worst O(m), best case O(r)
		while(!dict.isEmpty() && st.hasMoreTokens()) {
			String tempString = st.nextToken(" ");
			Integer value = dict.get(tempString);
			
			if(value!=null && value==1) {
				dict.remove(tempString);
			} else if(value!=null && value>1) {
				dict.put(tempString, --value);
			}
		}
		
		return dict.isEmpty();
	}


}
