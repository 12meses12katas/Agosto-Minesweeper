package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinesweeperTest {

    @Test
    public void noMineOnOneLine() {
        Minesweeper minesweeper = new Minesweeper("....");
        assertArrayEquals(createStringArray("0000"), minesweeper.solve());
    }

    @Test
    public void oneMineOnOneLine() {
        Minesweeper minesweeper = new Minesweeper("..*.");
        assertArrayEquals(createStringArray("01*1"), minesweeper.solve());
    }

    @Test
    public void twoMinesOnTheEdgeOfTheField() {
        Minesweeper minesweeper = new Minesweeper("*....*");
        assertArrayEquals(createStringArray("*1001*"), minesweeper.solve());
    }

    @Test
    public void minesOnBothSideOfACellOnOneLine() {
        Minesweeper minesweeper = new Minesweeper(".*.*.*");
        assertArrayEquals(createStringArray("1*2*2*"), minesweeper.solve());
    }

    @Test
    public void noMinesOnTwoLines() {
        Minesweeper minesweeper = new Minesweeper("..","..");
        assertArrayEquals(createStringArray("00", "00"), minesweeper.solve());
    }

    @Test
    public void allMines() {
        Minesweeper minesweeper = new Minesweeper("**","**");
        assertArrayEquals(createStringArray("**", "**"), minesweeper.solve());
    }

    @Test
    public void minesAffectSuperiorAndInferiorLines() {
        Minesweeper minesweeper = new Minesweeper("*.",".*");
        assertArrayEquals(createStringArray("*2", "2*"), minesweeper.solve());
    }

    @Test
    public void minesAffectCellsDiagonally() {
        Minesweeper minesweeper = new Minesweeper("...",".*.","...");
        assertArrayEquals(createStringArray("111","1*1", "111"), minesweeper.solve());
    }

    private String[] createStringArray(String... strings) {
        return strings;
    }

}
