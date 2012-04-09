package minesweeper;

public class Minesweeper {

    public static final int[][] SURROUNDING_CELLS = {{0,-1}, {0,1}, {-1,0}, {1,0}, {1,-1}, {-1,-1}, {1,1}, {-1,1}};

    private String[] field;
    private final int nbRows;
    private final int nbColumns;

    public Minesweeper(String... field) {
        this.field = field;
        nbRows = this.field.length;
        nbColumns = this.field[0].length();
    }

    public String[] solve() {

        char[][] securedField = new char[nbRows][nbColumns];

        replaceAllNonMinesByZeros(securedField);
        findMinesAndIncrementMinesCountAroundThem(securedField);
        return convertCharDoubleArrayToStringArray(securedField);
    }

    private void replaceAllNonMinesByZeros(char [][]charField) {
        for (int i = 0; i < nbRows; i++) {
            field[i] = field[i].replaceAll("\\.", "0");
            charField[i] = field[i].toCharArray();
        }
    }

    private void findMinesAndIncrementMinesCountAroundThem(char[][] securedField) {
        for (int row = 0; row < nbRows; row++) {
            for (int mineLocation = 0; field[row].indexOf("*", mineLocation) != -1; mineLocation++) {
                mineLocation = field[row].indexOf("*", mineLocation);
                incrementMinesCountAroundMine(securedField, row, mineLocation);
            }
        }
    }

    private void incrementMinesCountAroundMine(char[][] securedField, int mineRow, int mineColumn) {
        for (int[] cell : SURROUNDING_CELLS) {
            if (isInBound(mineRow + cell[0], mineColumn + cell[1]) && isNotAMine(securedField[mineRow + cell[0]][mineColumn + cell[1]]))
                securedField[mineRow + cell[0]][mineColumn + cell[1]] = incrementMinesCount(securedField[mineRow + cell[0]][mineColumn + cell[1]]);
        }
    }

    private boolean isNotAMine(char cell) {
        return cell != '*';
    }

    private char incrementMinesCount(char cell) {
        return (char) (cell + 1);
    }

    private boolean isInBound(int row, int column) {
        return row >= 0 && row < nbRows && column >= 0 && column < nbColumns;
    }

    private String[] convertCharDoubleArrayToStringArray(char[][] securedField) {
        String[] returnedField = new String[nbRows];
        for (int i = 0; i < securedField.length; i++) {
            returnedField[i] = new String(securedField[i]);
        }
        return returnedField;
    }
}
