import org.junit.Test

import static org.junit.Assert.*

class LineTests {
	
	@Test
	void shoultReturnSize() {
		
		Line line = new Line("...")
		assertEquals 3, line.size()
	}
	
	@Test
	void linesShouldBeInitialized() {
		
		Line line = new Line(".*.")
		assertEquals "0*0", line.toString()
	}
	
	@Test
	void shouldStorePlaces() {
		
		Line line = new Line("...")
		assertNotNull line.places()
		assertEquals 3, line.places().size()
	}
}