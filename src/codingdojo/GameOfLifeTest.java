/**
 * 
 */
package codingdojo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author morsi
 *
 */
public class GameOfLifeTest {

	@Test
	public void rightSizeOfInput() {
		String input = "...";
		GameOfLife game = new GameOfLife(input);
		assertEquals(3, game.sizeOfInput());
	}
	
	@Test
	public void rightSizeOfInputWhenThereIsCarriageReturn() {
		String input = "...\n...";
		GameOfLife game = new GameOfLife(input);
		assertEquals(6, game.sizeOfInput());
	}
	
	@Test
	public void rightSizeOfRow() {
		String input = "...\n...";
		GameOfLife game = new GameOfLife(input);
		assertEquals(2, game.sizeOfRow());
		
		input = "...\n...\n...\n...\n...\n...\n";
		game = new GameOfLife(input);
		assertEquals(6, game.sizeOfRow());
	}
	
	@Test
	public void rightSizeOfColumn() {
		String input = "...\n...";
		GameOfLife game = new GameOfLife(input);
		assertEquals(3, game.sizeOfColumn());
		
		input = "...\n...\n...\n...\n";
		game = new GameOfLife(input);
		assertEquals(3, game.sizeOfColumn());
	}
	
	@Test
	public void selectSpecificCellNotNull() {
		String input = ".*.\n...";
		GameOfLife game = new GameOfLife(input);
		Cell testCell = game.selectSpecificCell(0,1);
		assertNotNull(testCell);
	}
	
	@Test
	public void selectRightSpecificCell() {
		String input = ".*.\n...";
		GameOfLife game = new GameOfLife(input);
		Cell testCell = game.selectSpecificCell(0,1);
		assertTrue(testCell.isAlive());
		
		assertFalse(game.selectSpecificCell(0,0).isAlive());
		assertFalse(game.selectSpecificCell(0,2).isAlive());
		assertFalse(game.selectSpecificCell(1,0).isAlive());
		assertFalse(game.selectSpecificCell(1,1).isAlive());
		assertFalse(game.selectSpecificCell(1,2).isAlive());
	}

}
