package codility.lessons;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author morsi
 *
 */
public class FrogJmp {
	
	int solution(int X, int Y, int D) {
		int integerDiv = (Y-X)/D;
		int rest = (Y-X)%D;
		if(rest>0) {
			return 1+integerDiv;
		} else {
			return integerDiv;
		}
	}
	
	@Test
	public void test() {
		assertEquals(3, solution(10, 85, 30));
		assertEquals(3, solution(10, 71, 30));
		assertEquals(2, solution(10, 70, 30));
		assertEquals(0, solution(10, 10, 30));
	}

}
