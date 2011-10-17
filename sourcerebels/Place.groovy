class Place {
	
	public static final String SAFE = '.'
	public static final String MINE = '*'
	
	private String place
	
	public Place(String input) {
		place = initializePlace(input)
	}

	@Override
	public String toString() {
		return place
	}
	
	public Boolean mine() {
		return place == MINE
	}
	
	private String initializePlace(String place) {
		if (place == SAFE) {
			return '0'
		}
		return place
	}
}