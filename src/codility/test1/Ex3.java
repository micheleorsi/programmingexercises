package codility.test1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex3 {
	
	public boolean solution(int[] A) {
		
	}
	
	@Test
	public void test() {
		assertEquals(true, solution(new int[]{1,2}));
		assertEquals(true, solution(new int[]{2,1}));
		assertEquals(true, solution(new int[]{1,2,3}));
		assertEquals(true, solution(new int[]{3,2,1}));
		assertEquals(true, solution(new int[]{2,3,1}));
		assertEquals(true, solution(new int[]{1,3,2}));
		assertEquals(true, solution(new int[]{1,5,3,3,7}));
		assertEquals(false, solution(new int[]{1,3,5,3,4}));

	}

}
