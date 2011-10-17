import org.junit.Test

import static org.junit.Assert.*

class BoardTests {
	
	@Test
	void shouldResolve1x1BoardWithoutMines() {
		Board board = new Board("1 1")
		board.parse(".\n")
		
		assertEquals 1, board.height
		assertEquals 1, board.width
		assertEquals "0\n", board.resolve()
	}
	
	@Test
	void shouldDetectLasBoard() {
		Board board = new Board("0 0")
		assertTrue board.lastBoard()
	}
	
	@Test
	void shouldResolve1x1BoardWithMines() {
		Board board = new Board("1 1")
		board.parse("*\n")
		assertEquals "*\n", board.resolve()
	}
	
	@Test
	void shouldResolve2x2BoardWithoutMines() {
		Board board = new Board("2 2")
		board.parse("..\n..\n")
		assertEquals "00\n00\n", board.resolve()
	}
	
	@Test
	void shouldResolve2x2BoardWithAMine() {
		Board board = new Board("2 2")
		board.parse("*.\n..\n")
		assertEquals "*1\n11\n", board.resolve()
	}
	
	@Test
	void shouldResolveMoreComplexGame() {
		Board board = new Board("4 4")
		board.parse("*...\n*.*.\n....\n...*\n")
		assertEquals "*311\n*3*1\n1222\n001*\n", board.resolve()
	}
}
