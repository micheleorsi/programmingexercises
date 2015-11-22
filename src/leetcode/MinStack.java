/**
 * 
 */
package leetcode;

import java.util.LinkedList;

/**
 * @author morsi
 *
 */
public class MinStack {	
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> min = new LinkedList<Integer>();

    public void push(int x) {
        stack.add(x); // O(1)
        if(min.isEmpty()) {
        	min.add(x);
        } else {
        	if(x<min.peekLast()) {
    			min.add(x);
    		} else {
    			min.add(min.peekLast());
    		}
        }
    }

    public void pop() {
    	min.pollLast();
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
    	if(!min.isEmpty()) {
    		return min.peekLast();
    	} else {
    		return -1;
    	}
        
    }
}
