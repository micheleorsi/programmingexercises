package codility.test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex2 {
	
	public int solution(int[] A) {
		int numberOfPairs = 0;
		String checkAdj = "DEFAULT";
		
		for(int i = 1; i < A.length; i++) {
			// add number of pairs
		    if (A[i-1] == A[i]) {
		    	numberOfPairs++;
		    }
		    // this is not a pair
		    if (A[i-1] != A[i]) {
		      if(checkAdj.equals("DEFAULT")) {
		    	  checkAdj = "DIFF_FROM_PREV";
		      }
		      // if the actual is different from the following one
		      
		      else if (i+1 < A.length && 
		    		  A[i] != A[i+1]) {
		    	  checkAdj = "DIFF_FROM_NEXT";
		      }
		    }
		  }
		switch(checkAdj) {
			case "DEFAULT": return numberOfPairs - 1;
			case "DIFF_FROM_PREV": return numberOfPairs;
			case "DIFF_FROM_NEXT": return numberOfPairs+2;
		}
		return numberOfPairs;
	}
	
	@Test
	public void test() {
		assertEquals(5, solution(new int[] {1,1,0,1,0,0,1,1}));

	}

}
