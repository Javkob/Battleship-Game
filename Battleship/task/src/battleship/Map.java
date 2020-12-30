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
        System.out.print("\n");
        for (String[] element : matrix) {
            System.out.println(
                    Arrays.toString(element)
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }
        System.out.print("\n");
    }

    private Coordinates getPoint(String coordinates) {
        int x = getLetterValue(coordinates.toUpperCase().charAt(0));
        int y = Integer.parseInt(coordinates.replaceAll("[\\D]", ""));
        return new Coordinates(x, y);
    }

    void initializeShip(Ship ship) {
        System.out.printf("Enter the coordinates of the %s (%d cells)\n", ship.getName(), ship.getSize());
        getInput(ship);
    }

    void getInput(Ship ship) {
        Scanner scanner = new Scanner(System.in);
        String firstPoint = scanner.next();
        String secondPoint  = scanner.next();
        Coordinates firstCoordinate = getPoint(firstPoint);
        Coordinates secondCoordinate = getPoint(secondPoint);
        placeShipOnMap(ship,firstCoordinate,secondCoordinate);
    }

    private void placeShipOnMap(Ship ship,Coordinates firstCoordinate, Coordinates secondCoordinate) {
        swapPointsIfNeeded(firstCoordinate,secondCoordinate);
        if(!(verifyInput(firstCoordinate, secondCoordinate, ship))) {
            drawShipOnMap(firstCoordinate, secondCoordinate);
        }else{
            getInput(ship);
        }

    }

    private boolean verifyInput(Coordinates firstCoordinates, Coordinates secondCoordinates, Ship ship) {
        if (checkCollision(firstCoordinates, secondCoordinates)) {
            System.out.print("\nError! You placed it too close to another one. Try again:\n");
            return true;
        }else if (firstCoordinates.getX() != secondCoordinates.getX() && firstCoordinates.getY() != secondCoordinates.getY()) {
            System.out.print("\nError! Wrong ship location! Try again:\n");
            return  true;
        }else if (checkShipSize(firstCoordinates, secondCoordinates, ship)) {
            System.out.printf("\nError! Wrong length of the %s! Try again:\n", ship.getName());
            return true;
        }
        return false;
    }

    private void drawShipOnMap(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        for (int i = firstCoordinates.getX(); i <= secondCoordinates.getX(); i++) {
            for (int j = firstCoordinates.getY(); j <= secondCoordinates.getY(); j++) {
                matrix[i][j] = SHIP_PART;
            }
        }
    }

    private boolean checkCollision(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        int x1 = beyondMap(firstCoordinates.getX()- 1);
        int y1 = beyondMap(firstCoordinates.getY()- 1);
        int x2 = beyondMap(secondCoordinates.getX()+ 1);
        int y2 = beyondMap(secondCoordinates.getY()+ 1) ;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (matrix[i][j] == SHIP_PART) {
                    return true;
                }
            }
        }
        return false;
    }


    private void swapPointsIfNeeded(Coordinates firstCoordinate, Coordinates secondCoordinate) {
        if (firstCoordinate.getX() > secondCoordinate.getX() || firstCoordinate.getY() > secondCoordinate.getY()) {
            Coordinates tempCoordinate = new Coordinates(firstCoordinate.getX(), firstCoordinate.getY());
            firstCoordinate.setX(secondCoordinate.getX());
            firstCoordinate.setY(secondCoordinate.getY());
            secondCoordinate.setX(tempCoordinate.getX());
            secondCoordinate.setY(tempCoordinate.getY());
        }
    }

    boolean checkShipSize(Coordinates firstCoordinates, Coordinates secondCoordinates, Ship ship) {
        if ((secondCoordinates.getX() - firstCoordinates.getX() > ship.getSize()-1)
                || (secondCoordinates.getY() - firstCoordinates.getY() > ship.getSize()-1)) {
            return true;
        } else if ((secondCoordinates.getX() - firstCoordinates.getX() < ship.getSize()-1)
                && (secondCoordinates.getY() - firstCoordinates.getY() < ship.getSize()-1)) {
            return true;
        }
        return false;
    }

    private int beyondMap(int x) {
        return x > 10 ? x - 1 : x < 1 ? x + 1 : x;
    }


    // This method return the coordinates letter value
    private int getLetterValue(char letter) {
        for (int i = 0; i < rowLetters.length(); i++) {
            if (letter == rowLetters.charAt(i)) {
                return i;
            }
        }
        return 0;
    }

}
