package battleship;

import battleship.ships.Ship;

import java.util.Arrays;
import java.util.Scanner;

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

    private Coordinates getPoint(String coordinates){
        int x = coordinates.charAt(0);
        int y = getLetterValue(coordinates.substring(1));
        return new Coordinates(x, y);
    }

    void placeShip(Ship ship){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the coordinates of the %s (%d cells)\n",ship.getName(),ship.getSize());
        String firstCoordinates = scanner.next();
        String secondCoordinates = scanner.next();
        
    }

    void drawShipOnMap(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        for (int i = firstCoordinates.getY(); i <= secondCoordinates.getY(); i++) {
            for (int j = firstCoordinates.getX(); j <= secondCoordinates.getX(); j++) {
                matrix[i][j] = SHIP_PART;
            }
        }
    }

    //TODO fix this
    void checkShipLocation(String y1, int x1,String y2, int x2) {
        for (int i = getLetterValue(y1); i <= getLetterValue(y2); i++) {
            for (int j = x1; j <= x2; j++) {
                if(matrix[i][j] == SHIP_PART){
                    System.out.println("Error! Wrong ship location! Try again:");
                    return;
                }else if (matrix[--i][--j] == SHIP_PART){
                    System.out.println("Error! Wrong ship location! Try again:");
                    return;
                }
            }
        }
    }

    // This method return the coordinates letter value
    int getLetterValue(String letter){
        for (int i = 0; i <rowLetters.length(); i++) {
            if(letter.contains(String.valueOf(rowLetters.charAt(i)))){
                return i;
            }
        }
        return 0;
    }

}
