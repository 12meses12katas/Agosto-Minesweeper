import org.junit.Test

import static org.junit.Assert.*

class LineParserTests {
	
	@Test
	void shouldParseALine() {
		
		LineParser parser = new LineParser("...\n")
		assertEquals 1, parser.lines.size()
	}
	
	@Test
	void shouldParseMoreThanOneLine() {
		
		LineParser parser = new LineParser("...\n...\n...\n")
		assertEquals 3, parser.lines.size()
	}
	
	@Test
	void shouldParse1PlaceLine() {
		
		LineParser parser = new LineParser(".\n")
		assertEquals 1, parser.lines.size()
	}
}