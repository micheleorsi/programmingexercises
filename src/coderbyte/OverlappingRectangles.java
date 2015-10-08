package coderbyte;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class OverlappingRectangles {
	String OverlappingRectangles(String[] strArr) { 
		  
		String[] firstRect = new String[]{strArr[0],
				strArr[1],
				strArr[2],
				strArr[3]};
		
		String[] secondRect = new String[]{strArr[4],
				strArr[5],
				strArr[6],
				strArr[7]};
		
		System.out.println(Arrays.toString(firstRect));
		System.out.println(Arrays.toString(secondRect));
		   
	    return "";
	  } 
	
	public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner  s = new Scanner(System.in);
	    OverlappingRectangles c = new OverlappingRectangles();
//	    System.out.print(c.NumberEncoding(s.nextLine())); 
	}
	
	@Test
	public void test() {
		OverlappingRectangles(new String[] {"(0,0)","(2,2)","(2,0)","(0,2)",
				"(1,0)","(1,2)","(6,0)","(6,2)"});
		OverlappingRectangles(new String[] {"(0,0)","(0,-2)","(3,0)","(3,-2)",
				"(2,-1)","(3,-1)","(2,3)","(3,3)"});
		OverlappingRectangles(new String[] {"(0,0)","(5,0)","(0,2)","(5,2)",
				"(2,1)",(5,1),(2,-1),(5,-1)");
		}
	}

}
