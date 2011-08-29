package minesweeper2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinesweeperTest {

    private Minesweeper minesweeper;

    @Test
    public void noMinesOnOneLine() {
        minesweeper = new Minesweeper("....");
        final String[] securedMineField = new String[]{"0000"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void noMinesOnOneLongerLine() {
        minesweeper = new Minesweeper("......");
        final String[] securedMineField = new String[]{"000000"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void oneMineOnOneLine() {
        minesweeper = new Minesweeper("..*..");
        final String[] securedMineField = new String[]{"01*10"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void twoMinesOnOneLine() {
        minesweeper = new Minesweeper("*.*..");
        final String[] securedMineField = new String[]{"*2*10"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void noMineWithTwoLines() {
        minesweeper = new Minesweeper("..", "..");
        final String[] securedMineField = new String[] {"00", "00"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void oneMineWithTwoLines() {
        minesweeper = new Minesweeper(".*.", "...");
        final String[] securedMineField = new String[] {"1*1", "111"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void twoMinesWithTwoLines() {
        minesweeper = new Minesweeper(".*.", "*..");
        final String[] securedMineField = new String[] {"2*1", "*21"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void allMinesWithTwoLines() {
        minesweeper = new Minesweeper("***", "***");
        final String[] securedMineField = new String[] {"***", "***"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void threeMinesWithTwoLines() {
        minesweeper = new Minesweeper("**.", "*.*");
        final String[] securedMineField = new String[] {"**2", "*4*"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void shouldCountMinesBelow() {
        minesweeper = new Minesweeper("*...", "....", ".*..", "....");
        final String[] securedMineField = new String[] {"*100", "2210","1*10", "1110"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }

    @Test
    public void minesOnFourLines() {
        minesweeper = new Minesweeper("**...", ".....", ".*...");
        final String[] securedMineField = new String[] {"**100", "33200","1*100"};
        assertArrayEquals(securedMineField, minesweeper.solve());
    }
}
