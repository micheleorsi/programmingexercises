package coderbyte;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringReduction {
	

	int stringReduction(String str) {
		if(str.length()==1) {
			return 1;
		}
		
		int strLenght = str.length();
		int counter = 1;
		boolean recursive = false;
		while(counter<strLenght && !recursive) {
			char actualChar = str.charAt(counter);
			char prevChar = str.charAt(counter-1);
			String substituteString = prevChar+""+actualChar;
			
			if(actualChar!=prevChar) {
				recursive = true;
				strLenght = stringReduction(str.substring(1, counter)+
						returnOtherChar(substituteString)+
						str.substring(counter+1, strLenght));
				
				
			}
			counter++ ;
			
		}
			
		return strLenght;
	}
	
	
	
	private char returnOtherChar(String str) {
		boolean a = str.contains("a");
		boolean b = str.contains("b");
		if (a==false) return 'a';
		if (b==false) return 'b';
		return 'c';
	}
	
	@Test
	public void test() {
		assertEquals(1, stringReduction("b"));
		assertEquals(2, stringReduction("aa"));
		assertEquals(2, stringReduction("bb"));
		assertEquals(2, stringReduction("cc"));
		
		assertEquals(1, stringReduction("bc"));
		assertEquals(1, stringReduction("ac"));
		assertEquals(1, stringReduction("ab"));
		
		assertEquals(1, stringReduction("bcab"));
		assertEquals(2, stringReduction("abcabc"));
		assertEquals(4, stringReduction("cccc"));
		
	}

}
