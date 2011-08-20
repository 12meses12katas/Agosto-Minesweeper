package com.docekatas.minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {
	
	@Test
	public final void testEmptyField() {
		Field field = new Field("");
		assertEquals("EmptyField", "", field.getResult());
	}

	@Test
	public final void testUnitaryFields() {
		Field field = new Field("1 1\n.");
		assertEquals("UnitaryField", "0\n", field.getResult());
		field = new Field("1 1\n*");
		assertEquals("UnitaryField", "*\n", field.getResult());
	}

	@Test
	public final void testComplexFields() {
		Field field = new Field("2 2\n..\n..");
		assertEquals("ComplexField", "00\n00\n", field.getResult());
		field = new Field("2 2\n*.\n..");
		assertEquals("ComplexField", "*1\n11\n", field.getResult());
		field = new Field("3 5\n**...\n.....\n.*...");
		assertEquals("ComplexField", "**100\n33200\n1*100\n", field.getResult());
	}

}
