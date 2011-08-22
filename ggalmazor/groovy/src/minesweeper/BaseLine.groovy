package minesweeper

abstract class BaseLine implements minesweeper.Line {
	def contents

	def isEOF() {
		EOF_DEFINITION == contents
	}
}
