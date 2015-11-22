package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlidingWindowMaximum {
	
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
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) {
            return new int[0];
        }
	    int[] returnArray = new int[(nums.length - k +1)];
	    int maxCounter = 0;
	    LinkedList<Integer> tempList = new LinkedList<Integer>();
	    returnArray[0] = nums[0];
	    for(int i=0; i<k; i++) {
	        tempList.add(nums[i]);
	        if(nums[i]>returnArray[0]) {
	            returnArray[0] = nums[i];
	        }
	    }
	    maxCounter++;
	    for(int i=k; i< nums.length; i++) {
	        tempList.add(nums[i]);
	        tempList.poll();
		    returnArray[maxCounter]= calculateMax(tempList);
		    maxCounter++;
	    }        
	    return returnArray;
    }
    
    private int calculateMax(LinkedList<Integer> input) {
	    int max = -10000000;
	    for (Integer integer : input) {
		    if(integer>max) {
			    max = integer;
    		}
	    }
	    return max;
    }
}