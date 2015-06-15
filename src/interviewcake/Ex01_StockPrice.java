/**
 * 
 */
package interviewcake;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * https://www.interviewcake.com/question/stock-price
 * 
 * I have an array stock_prices_yesterday where:
 * 
 * The indices are the time in minutes past trade opening time, which was 9:30am local time.
 * The values are the price in dollars of Apple stock at that time.
 * For example, the stock cost $500 at 10:30am, so stock_prices_yesterday[60] = 500.
 * Write an efficient algorithm for computing the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
 * No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).
 * 
 * @author morsi
 *
 */
public class Ex01_StockPrice {
	
	// time complex: O(n^2)
	// space complex: O(1)
//	public int bestProfit(int[] array) {
//		int maxProfit = 0;
//		if(array.length>1) {
//			maxProfit = array[1] - array[0];
//			if(array.length>2) {
//				for(int i=0; i<array.length; i++) {
//					for(int j=i+1; j<array.length; j++) {
//						int actualProfit = array[j]-array[i];	
//						if(actualProfit>maxProfit) {
//							maxProfit = actualProfit;
//						}
//					}
//				}
//			}
//		}
//		return maxProfit;
//	}
	
	// space: O(1)
	// time: O(n)
	public int bestProfit(int[] array) {
		int maxProfit = 0;
		if(array.length>1) {
			maxProfit = array[1] - array[0];
			if(array.length>2) {
				int min = array[0];
	
				for(int i=1; i<array.length; i++) {
					int actualProfit = array[i]-min;
					if(actualProfit>maxProfit) {
						maxProfit = actualProfit;
					}
					if(array[i]<min) {
						min = array[i];
						
					}
				}
			}
		}
		return maxProfit;
	}
	
	@Test
	public void test_EmptyArray(){
		int[] array = {};
		assertEquals(0, bestProfit(array));
	}
	
	@Test
	public void test_SingleArray(){
		int[] array = {1};
		assertEquals(0, bestProfit(array));
	}
	
	@Test
	public void test_TwoNumberArray(){
		int[] array = {1,1};
		assertEquals(0, bestProfit(array));
		int[] array1 = {1,11};
		assertEquals(10, bestProfit(array1));
		int[] array2 = {11,1};
		assertEquals(-10, bestProfit(array2));
	}
	
	@Test
	public void test_ThreeNumberArrayProfit(){
		int[] array = {10,2,5};
		assertEquals(3, bestProfit(array));
	}
	
	@Test
	public void test_GoesDownAllTheDay(){
		int[] array = {10,2,1};
		assertEquals(-1, bestProfit(array));
		int[] array2 = {-10,-20,-22};
		assertEquals(-2, bestProfit(array2));
	}
	
	@Test
	public void test_ALotOfNumberArrayProfit(){		
		int[] array2 = {10,2,100, 80, 20, 1000};
		assertEquals(1000-2, bestProfit(array2));
		
		int[] array3 = {100,200,1};
		assertEquals(100, bestProfit(array3));
		
		int[] array4 = {10,5,90,34,456,67,12,34,2,1};
		assertEquals(456-5, bestProfit(array4));
	}
}
