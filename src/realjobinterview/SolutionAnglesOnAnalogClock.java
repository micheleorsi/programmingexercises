/**
 * 
 */
package realjobinterview;

import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

/**
 * @author micheleorsi
 *
 */
public class SolutionAnglesOnAnalogClock {
	
	/**
	 * return the angle between hours and minutes on analog clock
	 * 
	 * @param hour 
	 * @param minute 
	 * @return
	 */
	public static float anglesOnAnalogClock(int hour, int minute) {
		int reducedHour = hour % 12;
		int reducedMinute = minute % 60;
		final int MAX_ANGLE = 360;
		float angleHour = (MAX_ANGLE/12.0f*reducedHour) + (MAX_ANGLE/12.0f/60*reducedMinute);
		float angleMinutes = (MAX_ANGLE/60.0f*reducedMinute);
		float absValue = Math.abs(angleHour-angleMinutes);
		return Math.min(MAX_ANGLE-absValue, absValue);
	}
	
	@Test
	public void testCase() {
		assertEquals(90.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(3, 00), 0);
		assertEquals(0.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(12, 00), 0);
		assertEquals(15.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(6, 30), 0);
		assertEquals(75.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(3, 30), 0);
		assertEquals(10.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(4, 20), 0);
		assertEquals(20.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(3, 20), 0);
		assertEquals(180f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(6, 0), 0);
		assertEquals(90+30+22.5f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(1, 45), 0);
		assertEquals(90+22.5f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(0, 45), 0);
		assertEquals(360/12/60.0f*59+360/60.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(0, 59), 0);
		
		// try with big number
		assertEquals(90+30+22.5f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(13, 45), 0);
		assertEquals(90+22.5f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(48, 45), 0);
		assertEquals(360/12/60.0f*59+360/60.0f, SolutionAnglesOnAnalogClock.anglesOnAnalogClock(24, 59), 0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        int hour = Integer.parseInt(st.nextToken(":"));
        int minute = Integer.parseInt(st.nextToken(":"));
        System.out.println(String.format("%.1f", SolutionAnglesOnAnalogClock.anglesOnAnalogClock(hour, minute)));
	}

}
