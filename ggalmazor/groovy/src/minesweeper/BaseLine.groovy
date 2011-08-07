package minesweeper

abstract class BaseLine implements minesweeper.Line {
	def contents

	boolean isEOF() {
		EOF_DEFINITION == contents
	}
}
