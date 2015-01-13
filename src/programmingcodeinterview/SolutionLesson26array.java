package programmingcodeinterview;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class SolutionLesson26array {

	@Test
	public void test1() {
		this.print(new int[]{1,2,3,4,5});
	}
	
	// time: O(n)
	// space: O(1)
	public void print(int[] n) {
		for (int number : n) {
			System.out.println(number);
		}
	}
	
	@Test
	public void test2() {
		assertEquals(4, this.search(3, new int[]{1,2,4,5,3,2,1}));
		assertEquals(-1, this.search(3, new int[]{1,2,4,5,30,2,1}));
	}
	
	// time: O(n)
	// space: O(1)
	public int search(int n, int[] array) {
		int index = 0;
		for(int actual : array) {
			if(actual==n) {
				return index; 
			}
			index++;
		}
		return -1;	
	}
	
	@Test
	public void test3() {
		assertEquals(4, this.findMax(new int[]{1,2,4,2,3,2,1}));
		assertEquals(100, this.findMax(new int[]{100,2,4,5,30,2,1}));
	}
	
	public int findMax(int[] array) {
		int max = 0;
		for(int number: array) {
			if(number>max) {
				max = number;
			}
		}
		return max;
	} 
	
	@Test
	public void test4() {
		assertEquals(true, this.find123(new int[]{1,2,4,2,3,2,1,2,3}));
		assertEquals(true, this.find123(new int[]{1,2,4,2,3,2,1,2,3,21,2}));
		assertEquals(false, this.find123(new int[]{100,2,4,5,30,2,1}));
		assertEquals(false, this.find123(new int[]{100,2,1,2,5,30,2,1}));
		assertEquals(true, this.find123(new int[]{1,2,4,2,3,2,1,2,3}));
	}
	
	public boolean find123(int[] array) {
		int[] testArray = new int[]{1,2,3};
		int indexExpected = 0;
		for(int actual: array) {
			if(actual==testArray[indexExpected]) {
				if(indexExpected==(testArray.length-1)) {
					return true;
				} else {
					indexExpected++;
				}
			} else {
				indexExpected=0;
			}
		}
		return false;
	}
	
	@Test
	public void test5() {
		assertEquals(false, this.headsInARow(new boolean[] {true,false,true,false,true}));
		assertEquals(true, this.headsInARow(new boolean[] {true,
				true,true,true,
				false,false,false,false,false,false,false,false,false,
				false,true,false,true}));
		assertEquals(true, this.headsInARow(new boolean[] {true,
				true,true,true,
				false,false,false,false,false,false,false,false,
				true,true,true,true,true,true,true,true,true,true,
				false,true,false,true}));
	}
	
	public boolean headsInARow(boolean[] array) {
		int count = 9;
		boolean test = array[0];
		for(int i = 1; i<array.length; i++) {
			if(array[i]==test) {
				count--;
			} else {
				count = 9;
				test=array[i];
			}
			if(count==0) {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void test6() {
		int[] array = new int[]{1,2,3,4,5,6,7};
		for(int number : array) {
			System.out.println(number);
		}
		this.shuffle(array);
		System.out.println();
		for(int number : array) {
			System.out.println(number);
		}
		
		int[] array2 = new int[]{1,2,3,4,5,6,7};
		for(int number : array2) {
			System.out.println(number);
		}
		this.shuffle2(array2);
		System.out.println();
		for(int number : array2) {
			System.out.println(number);
		}
	}
	
	public void shuffle(int[] array) {
		Random random = new Random();
		for(int i=0; i<array.length; i++) {
			int randomIndex = random.nextInt(array.length);
			int actualNumber = array[i];
			array[i]=array[randomIndex];
			array[randomIndex] = actualNumber;
		}
	}
	
	public void shuffle2(int[] array) {
		Random rand = new Random();
		int numberToPlace = array.length;
		for(int i=array.length-1; i>=0; i--) {
			int randomIndex = rand.nextInt(numberToPlace);
			int latestNumber = array[i];
			array[i]=array[randomIndex];
			array[randomIndex]=latestNumber;
			numberToPlace--;
		}
	}
	
	@Test
	public void test7() {
		int[] array = new int[]{1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(this.rotateRight(array, 2)));
	}

	public int[] rotateRight(int[] array, int steps) {
		int[] resultArray = new int[array.length]; 
		for(int i=0; i<array.length; i++) {
			resultArray[i] = array[(i+steps)%(array.length-1)];
		}
		return resultArray;
	}

	@Test
	public void test8() {
		int[] array = new int[]{9,8,1,10,2,3,4,5,6,7};
		this.simpleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public void simpleSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length; j++) {
				if(array[i]<array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
