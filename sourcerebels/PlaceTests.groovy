import org.junit.Test

import static org.junit.Assert.*

class PlaceTests {
	
	@Test
	void placeShouldBeInitialized() {
		
		Place place = new Place("*")
		
		assertEquals "*", place.toString()
		
		place = new Place(".")
		assertEquals "0", place.toString()
	}
	
	@Test
	void shouldDetectMines() {
		
		Place place = new Place("*")
		assertTrue place.mine()
		
		place = new Place(".")
		assertFalse place.mine()
	}
}