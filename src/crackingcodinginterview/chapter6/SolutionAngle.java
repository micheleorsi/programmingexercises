package crackingcodinginterview.chapter6;

import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionAngle {

	@Test
	public void testAngle() {
		assertEquals(90, this.calculateAngle(3, 30));
		assertEquals(0, this.calculateAngle(4, 20));
		assertEquals(270-240, this.calculateAngle(3, 20));
		assertEquals(180, this.calculateAngle(6, 0));
		assertEquals(180+60, this.calculateAngle(1, 45));
	}
	
	public int calculateAngle(int hour, int minute) {
		int angleHour = 360 - 360/12*hour;
		int angleMinutes = 360 - 360/60*minute;
		
		return angleHour < angleMinutes ? angleMinutes-angleHour : angleHour-angleMinutes;
	}
	
}
