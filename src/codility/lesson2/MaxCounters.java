/**
 * 
 */
package codility.lesson2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author morsi
 *
 */
public class MaxCounters {

	public int[] solution(int N, int[] A) {
        int maxValue = 0;
        int[] array = new int[N];
        for(int i=0; i<N; i++) {
        	array[i]=0;
        }
        
        int maxCounter = 0;
        
        for (int i : A) {
			if(i==N+1) {
				for(int j=0; j<N; j++) {
		        	array[j]=maxValue;
		        }
			} else {
				array[i-1] = array[i-1]+1;
				if(array[i-1]>maxValue) {
					maxValue=array[i-1];
				}
			}
		}
        
        for(int i=0; i<N; i++) {
        	if(array[i]==0) {
        		array[i]+=maxCounter;
        	}
        }
        return array;
    }
	
	@Test
	public void test() {
		assertEquals(3, solution(5, new int[]{3,4,4,6,1,4,4})[0]);
//		assertEquals(2, solution(5, new int[]{3,4,4,6,1,4,4})[1]);
//		assertEquals(2, solution(5, new int[]{3,4,4,6,1,4,4})[2]);
//		assertEquals(4, solution(5, new int[]{3,4,4,6,1,4,4})[3]);
//		assertEquals(2, solution(5, new int[]{3,4,4,6,1,4,4})[4]);
	}
}
