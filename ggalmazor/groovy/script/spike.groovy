def fields = []



System.in.withReader { prompt ->
	def n = 0
	def row
	String line
	def field
	while (true) {
		line = prompt.readLine()
		if ("0 0" == line || "" == line)
			break
		if (line.contains(" ")) {
			if (null != field) {
				if (row <= field.h)
					throw new Exception("Wrong row count: ${row - 1} (${field.h} declared)")
			}
			def space = line.indexOf(" ")
			field = [
					h: line[0..space - 1].toInteger(),
					w: line[space + 1..-1].toInteger(),
					tiles: []
			]
			fields << field
			row = 1
		} else {
			if (row > field.h) {
				throw new Exception("Wrong row count: ${row} (only ${field.h} declared)")
			}
			if (line.size() != field["w"]) {
				throw new Exception("Wrong width at row ${row}: ${line.length()}")
			}
			line.each { tile ->
				if ("." != tile && "*" != tile)
					throw new Exception("Invalid tile definition ([.: safe, *: mine])")
				field["tiles"] << tile
			}
			row++
		}
	}
}


fields.eachWithIndex { field, number->
	println ""
	println "Field #${number+1}:"
	def x, y
	def tiles = field.tiles
	for (y = 0; y < field.h; y++) {
		for (x = 0; x < field.w; x++) {
			def tile = getTileInPosition(x, y, field)
			if ("." == tile) {
				def mines = 0
				if ("*" == getTileInPosition(x - 1, y + 1, field))
					mines ++
				if ("*" == getTileInPosition(x, y + 1, field))
					mines ++
				if ("*" == getTileInPosition(x + 1, y + 1, field))
					mines ++
				if ("*" == getTileInPosition(x - 1, y, field))
					mines ++
				if ("*" == getTileInPosition(x, y, field))
					mines ++
				if ("*" == getTileInPosition(x + 1, y, field))
					mines ++
				if ("*" == getTileInPosition(x - 1, y - 1, field))
					mines ++
				if ("*" == getTileInPosition(x, y - 1, field))
					mines ++
				if ("*" == getTileInPosition(x + 1, y - 1, field))
					mines ++
				tile = mines
			}
			print "${tile}"
		}
		println ""
	}
}

private def getTileInPosition(int x, int y, field) {
	def position = getPosition(x, y, field)
	if (null != position)
		return field.tiles[position]
	return null
}

private def getPosition(int x, int y, field) {
	if (x < 0 || y < 0 || x >= field.w || y >= field.h)
		return null
	x + y * field.w
}

