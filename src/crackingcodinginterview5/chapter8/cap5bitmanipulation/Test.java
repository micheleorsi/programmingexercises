package crackingcodinginterview5.chapter8.cap5bitmanipulation;

import static org.junit.Assert.*;

public class Test {

	int getBit(int num, int i) { 
		return ((num & (1 << i)));
	}

	@org.junit.Test
	public void test() {
//		System.out.println(8);
		System.out.println(getBit(8,3));
	}

}
