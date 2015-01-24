package realjobinterview;

import org.junit.Test;

public class SolutionStringTest {
	
	@Test
	public void ex1() {
		String s = " Hello ";
		s += "World ";
		s.replace('H', 'M');
		s.trim();
		System.out.println(s);
	}
	
	@Test
	public void ex2() {
		Object s1 = new String("Hello");
		Object s2 = new String("Hello");

		System.out.println("ex1:");
		System.out.println("identity:: " + (s1 == s2) );
		System.out.println("equality:: " + s1.equals(s2) );
		
		s1 = "Hello";
		s2 = "Hello";

		System.out.println("ex2:");
		System.out.println("identity:: " + (s1 == s2) );
		System.out.println("equality:: " + s1.equals(s2) );
	}

}
