/**
 * 
 */
package lucainterviews;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author micheleorsi
 *
 */
public class NavigateTreeDepthFirst {

	@Test
	public void test() {
//		NodeTree nodeA = new Node(value, next);
	}
	
	
	

}

class NodeTree {
	public Node left = null;
	public Node right = null;
	public String value;
	
	public NodeTree(String value, 
			Node left,
			Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
