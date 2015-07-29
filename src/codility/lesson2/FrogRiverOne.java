/**
 * 
 */
package codility.lesson2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author morsi
 *
 */
public class FrogRiverOne {

	
	public int solution(int X, int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=X; i++) {
			set.add(i);
		}
		int step = 0;
		for (int number : A) {
			set.remove(number);
			if(set.isEmpty()) {
				return step;
			}
			step++;
		}
		return -1;
	}
	
	@Test
	public void test() {
		assertEquals(0, solution(1, new int[]{1,3,1,4,2,3,5,4}));
		assertEquals(4, solution(2, new int[]{1,3,1,4,2,3,5,4}));
		assertEquals(4, solution(3, new int[]{1,3,1,4,2,3,5,4}));
		assertEquals(6, solution(5, new int[]{1,3,1,4,2,3,5,4}));
		assertEquals(-1, solution(5, new int[]{1,3,1,4,2,3,2,4}));
		assertEquals(-1, solution(6, new int[]{1,3,1,4,2,3,2,4}));
	}
}
