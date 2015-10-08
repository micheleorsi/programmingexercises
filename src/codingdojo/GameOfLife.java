package codingdojo;

/**
 * Your task is to write a program to calculate the next
generation of Conway's game of life, given any starting
position. You start with a two dimensional grid of cells, 
where each cell is either alive or dead. The grid is finite, 
and no life can exist off the edges. When calculating the 
next generation of the grid, follow these four rules:

1. Any live cell with fewer than two live neighbours dies, 
   as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, 
   as if by overcrowding.
3. Any live cell with two or three live neighbours lives 
   on to the next generation.
4. Any dead cell with exactly three live neighbours becomes 
   a live cell.

Examples: * indicates live cell, . indicates dead cell

Example input: (4 x 8 grid)
4 8
........
....*...
...**...
........

Example output:
4 8
........
...**...
...**...
........

 * 
 * @author morsi
 *
 */
public class GameOfLife {
	
	protected String input = null;
	protected Cell[] cells = null;
	protected int numberOfRow = -1;
	protected int numberOfColumn = -1;

	public GameOfLife(String input) {
		this.input = input;
		numberOfRow = input.split("\n").length;
		numberOfColumn = input.split("\n")[0].length();
		cells = new Cell[this.sizeOfInput()];
		int counter = 0;
		for (char c : input.toCharArray()) {
			if(c!='\n') {
				cells[counter] = new Cell(c);
				counter++;
			}
		}
	}

	public int sizeOfInput() {
		return this.numberOfRow*this.numberOfColumn;
	}

	public int sizeOfRow() {
		return numberOfRow;
	}

	public int sizeOfColumn() {
		return numberOfColumn;
	}

	public Cell selectSpecificCell(int indexRow, int indexColumn) {
		int index = ((indexRow) * numberOfColumn ) + indexColumn;
		return cells[index];
	}

}
