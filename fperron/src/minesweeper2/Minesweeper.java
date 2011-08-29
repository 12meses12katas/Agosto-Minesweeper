package minesweeper2;

public class Minesweeper {

    private static final char MINE = '*';
    public static final int[][] SURROUNDING_CELLS = {{0,-1}, {0,1}, {-1,0}, {1,0}, {1,-1}, {-1,-1}, {1,1}, {-1,1}};

    private char[][] field;
    private final int rows;
    private final int columns;

    public Minesweeper(String... field) {
        this.field = stringFieldToCharField(field);
        rows = this.field.length;
        columns = this.field[0].length;
    }

    public String[] solve() {

        char[][] securedField = new char[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                securedField[i][j] = isAMine(i, j) ? MINE : countMineAroundCell(i, j);

        return charFieldToStringField(securedField);
    }

    private char countMineAroundCell(int i, int j) {
        int mineCount = 0;
        for (int[] cell : SURROUNDING_CELLS) {
            mineCount += incrementMineCountIfCellIsAMine(i + cell[0], j + cell[1]);
        }
        return (char) ('0' + mineCount);
    }

    private boolean isAMine(int i, int j) {
        return field[i][j] == MINE;
    }

    private int incrementMineCountIfCellIsAMine(int row, int column) {
        return isInBound(row, column) && isAMine(row, column) ? 1 : 0;
    }

    private boolean isInBound(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private static char[][] stringFieldToCharField(final String[] stringField) {
        char[][] charField = new char[stringField.length][stringField[0].length()];
        for (int i = 0; i < stringField.length; i++) {
            charField[i] =  stringField[i].toCharArray();
        }
        return charField;
    }

    private static String[] charFieldToStringField(final char[][] charField) {
        String[] stringField = new String[charField.length];
        for (int i = 0; i < stringField.length; i++) {
            stringField[i] =  new String(charField[i]);
        }
        return stringField;
    }
}