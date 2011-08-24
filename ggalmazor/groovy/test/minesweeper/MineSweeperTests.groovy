package minesweeper

import org.junit.Test
import org.junit.Before
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.is

class MineSweeperTests {
	@Before
	void resetFieldRepository() {
		FieldRepository.reset()
	}

	@Test
	void "Crea un campo de minas de 1 por 1"() {
		def input = [
				"1 1",
				".",
				"0 0"
		]
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat FieldRepository[0].width, is(1)
		assertThat FieldRepository[0].height, is(1)
	}

	@Test
	void "Crea dos campos de minas"() {
		def input = [
				"1 1",
				".",
				"2 2",
				"..",
				"..",
				"0 0"
		]
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat FieldRepository[0].width, is(1)
		assertThat FieldRepository[1].height, is(2)
	}

	@Test
	void "Resuelve campos de 1 por 1"() {
		def input = [
				"1 1",
				".",
				"1 1",
				"*",
				"0 0"
		]
		def solution = """Field #1:
0

Field #2:
*

"""
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat mineSweeper.getAllSolutions(), is(solution)
	}

	@Test
	void "Resuelve campos de 1 por 3"() {
		def input = [
				"1 3",
				"...",
				"1 3",
				".*.",
				"0 0"
		]
		def solution = """Field #1:
000

Field #2:
1*1

"""
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat mineSweeper.getAllSolutions(), is(solution)
	}

	@Test
	void "Resuelve campos de 3 por 3"() {
		def input = [
				"3 3",
				"...",
				".*.",
				"...",
				"3 3",
				".*.",
				".**",
				".*.",
				"0 0"
		]
		def solution = """Field #1:
111
1*1
111

Field #2:
2*3
3**
2*3

"""
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat mineSweeper.getAllSolutions(), is(solution)
	}

	@Test
	void "Test de aceptación"() {
		def input = [
				"4 4",
				"*...",
				"....",
				".*..",
				"....",
				"3 5",
				"**...",
				".....",
				".*...",
				"0 0"
		]
		def solution = """Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100

"""
		def mineSweeper = new MineSweeper()
		mineSweeper.solve(input)
		assertThat mineSweeper.getAllSolutions(), is(solution)
	}
}












