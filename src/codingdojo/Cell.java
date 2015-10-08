/**
 * 
 */
package codingdojo;

/**
 * @author morsi
 *
 */
public class Cell {
	protected boolean isAlive = false;
	protected static final char ALIVE_CELL = '*';

	public Cell(char charAt) {
		isAlive = (charAt==ALIVE_CELL);
	}

	public boolean isAlive() {
		return isAlive;
	}

}
