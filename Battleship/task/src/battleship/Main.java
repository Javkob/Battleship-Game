package battleship;

import battleship.ships.*;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(10,10);

        Ship aircraftCarrier = new AircraftCarrier();
        Ship battleship = new Battleship();
        Ship submarine = new Submarine();
        Ship cruiser = new Cruiser();
        Ship destroyer = new Destroyer();



        map.display();

    }
}
