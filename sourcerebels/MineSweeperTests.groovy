import org.junit.Test

import static org.junit.Assert.*

class MineSweeperTests {
	
	@Test
	void shouldResolveComplexGame() {
		
		String input = "4 4\n" +
                       "*...\n" +
                       "....\n" +
                       ".*..\n" +  
                       "....\n" +
                       "3 5\n" +
                       "**...\n" +
                       ".....\n" +
                       ".*...\n" + 
                       "0 0\n"

		String expected = "Field #1:\n" +
                          "*100\n" +
                          "2210\n" +
                          "1*10\n" +
                          "1110\n" +
                          "\n" + 
                          "Field #2:\n" +
                          "**100\n" +
                          "33200\n" +
                          "1*100\n"


		MineSweeper game = new MineSweeper(input)
		assertEquals expected, game.resolve()
	}
}