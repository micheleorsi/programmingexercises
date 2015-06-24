/**
 * 
 */
package codility;

import java.util.*;

/**
 * @author morsi
 *
 */
public class PrefixSet {
	
	public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>(A.length/2);
        
        for(int i=0; i<A.length; i++) {
			set.add(A[i]);
		}
		
		for(int i=0; i<A.length; i++) {
			set.remove(A[i]);
			if(set.size()==0) {
				return i;
			}
		}
        
		return -1;
    }

}
