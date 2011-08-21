package com.docekatas.minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperTest {

	@Test
	public final void test() {
		Minesweeper mines = new Minesweeper(
				"4 4\n" +
				"*...\n" +
				"....\n" +
				".*..\n" +
				"....\n" +
				"3 5\n" +
				"**...\n" +
				".....\n" +
				".*...\n" +
				"0 0"
		);
		assertEquals(
				"Minesweeper", 
				"Field #1:\n" +
				"*100\n" +
				"2210\n" +
				"1*10\n" +
				"1110\n" +
				"\n" +
				"Field #2:\n" +
				"**100\n" +
				"33200\n" +
				"1*100\n" +
				"\n",
				mines.getResult());
	}

}
