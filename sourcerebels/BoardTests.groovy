import org.junit.Test

import static org.junit.Assert.*

class BoardTests {
	
	@Test
	void shouldResolve1x1BoardWithoutMines() {
		Board board = new Board(".\n")
		assertEquals "0\n", board.resolve()
	}
	
	@Test
	void shouldResolve1x1BoardWithMines() {
		Board board = new Board("*\n")
		assertEquals "*\n", board.resolve()
	}
	
	@Test
	void shouldResolve2x2BoardWithoutMines() {
		Board board = new Board("..\n..\n")
		assertEquals "00\n00\n", board.resolve()
	}
	
	@Test
	void shouldResolve2x2BoardWithAMine() {
		Board board = new Board("*.\n..\n")
		assertEquals "*1\n11\n", board.resolve()
	}
	
	@Test
	void shouldResolveMoreComplexGame() {
		Board board = new Board("*...\n*.*.\n....\n...*\n")
		assertEquals "*311\n*3*1\n1222\n001*\n", board.resolve()
	}
}
