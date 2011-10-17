class Line {
	
	private List<Place> places
	
	public Line(String input) {
		initializeLine()
		parseLine(input)
	}
	
	public String toString() {
		return places.collect { it.toString() }.join()
	}
	
	public Integer size() {
		return places.size()
	}
	
	public List<Place> places() {
		return places
	}
	
	private void initializeLine() {
		places = []
	}
	
	private void parseLine(String input) {
		input.each { place ->
			places.add(new Place(place))
		}
	}
}