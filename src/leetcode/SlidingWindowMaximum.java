package leetcode;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

public class SlidingWindowMaximum {
	int[] test = new int[3];
	
	@Test
	public void test() {
		int[] testArray = {7,2,4};
		int[] returnArray = this.maxSlidingWindow(testArray, 2);
		assertEquals(7,returnArray[0]);
		assertEquals(4,returnArray[1]);
	}
	
	@Test
	public void test2() {
		int[] testArray = {1};
		int[] returnArray = this.maxSlidingWindow(testArray, 1);
		assertEquals(1,returnArray[0]);
	}
	
	@Test
	public void test3() {
		int[] testArray = {};
		int[] returnArray = this.maxSlidingWindow(testArray, 1);
		assertEquals(0,returnArray.length);
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) {
            return new int[0];
        }
	    int[] returnArray = new int[(nums.length - k +1)];
	    for(int i=0; i< nums.length-k+1; i++) {
		    int[] tempArray = Arrays.copyOfRange(nums,i,i+k);
		    returnArray[i]= calculateMax(tempArray);
	    }        
	    return returnArray;
    }
    
    private int calculateMax(int[] input) {
	    int max = -10000000;
	    for(int i=0; i<input.length; i++) {
		    if(input[i]>max) {
			    max = input[i];
    		}
	    }
	    return max;
    }
}
