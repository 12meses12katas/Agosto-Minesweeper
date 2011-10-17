import org.junit.Test

import static org.junit.Assert.*

class BoardParserTests {
	
	@Test
	void shouldParseABoard() {

		BoardParser parser = new BoardParser("1 1\n.\n0 0\n")
		List<Board> boards = parser.boards
		
		assertEquals 1, boards.size()
		assertEquals "0\n", boards[0].resolve()
	}
	

	@Test
	void shouldParseAListOfBoards() {
		
		String input = "3 3\n...\n.**\n..*\n2 2\n*.\n..\n0 0"

		BoardParser parser = new BoardParser(input)
		List<Board> boards = parser.boards
		
		assertEquals 2, boards.size()
		assertEquals "122\n1**\n13*\n", boards[0].resolve()
		assertEquals "*1\n11\n", boards[1].resolve()
	}
}