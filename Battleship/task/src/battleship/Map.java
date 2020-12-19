package battleship;

import java.util.Arrays;

public class Map {
    private String[][] matrix;
    private final String SHIP_PART = "O";
    private final String FOG_OF_WAR = "~";
    private int rowsWithNum;
    private int columnsWithNum;
    private String rowLetters = " ABCDEFGHIJ";

    public Map(int rows, int columns) {
        this.rowsWithNum = rows + 1;
        this.columnsWithNum = columns + 1;
        this.matrix = new String[rowsWithNum][columnsWithNum];
        create();
    }

    public void create() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    matrix[i][j] = String.valueOf(j == 0 ? " " : j);
                } else if (j == 0) {
                    matrix[i][j] = String.valueOf(rowLetters.charAt(i));
                } else {
                    matrix[i][j] = FOG_OF_WAR;
                }
            }
        }
    }

    void display() {
        for (String[] element : matrix) {
            System.out.println(
                    Arrays.toString(element)
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }
        System.out.print("\n");
    }

    void markShip(String y1, int x1,String y2, int x2) {
        for (int i = letterValue(y1); i <= letterValue(y2); i++) {
            for (int j = x1; j <= x2; j++) {
                matrix[i][j] = SHIP_PART;
            }
        }
    }

    int letterValue (String letter){
        for (int i = 0; i <rowLetters.length(); i++) {
            if(letter.contains(String.valueOf(rowLetters.charAt(i)))){
                return i;
            }
        }
        return 0;
    }

}
