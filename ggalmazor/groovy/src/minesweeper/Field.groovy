package minesweeper

class Field {
	public static final String SAFE_TILE = "."
	public static final String MINE_TILE = "*"
	int width, height
	def tiles = []

	void addTile(String tile) {
		tiles << tile
	}

	int getPosition(int x, int y) {
		x + y * width
	}

	int countMinesAt(int x, int y) {
		def mines = 0
		mines += isPositionMined(x - 1, y - 1) ? 1 : 0
		mines += isPositionMined(x, y - 1) ? 1 : 0
		mines += isPositionMined(x + 1, y - 1) ? 1 : 0
		mines += isPositionMined(x - 1, y) ? 1 : 0
		mines += isPositionMined(x + 1, y) ? 1 : 0
		mines += isPositionMined(x - 1, y + 1) ? 1 : 0
		mines += isPositionMined(x, y + 1) ? 1 : 0
		mines += isPositionMined(x + 1, y + 1) ? 1 : 0
		return mines
	}

	boolean isPositionSafe(int x, int y) {
		SAFE_TILE == getTileAtPosition(x, y)
	}

	boolean isPositionMined(int x, int y) {
		MINE_TILE == getTileAtPosition(x, y)
	}

	def getTileAtPosition(int x, int y) {
		if (isOutOfBounds(x, y))
			return null
		return tiles[getPosition(x, y)]
	}

	private boolean isOutOfBounds(int x, int y) {
		return x < 0 || x >= width || y < 0 || y >= height
	}

	void setMinesAt(int x, int y, int mines) {
		tiles[getPosition(x, y)] = mines
	}
}
