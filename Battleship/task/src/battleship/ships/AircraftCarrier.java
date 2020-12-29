package battleship.ships;

public class AircraftCarrier implements Ship{

    private static final String NAME = "Aircraft Carrier";
    private static final int SIZE = 5;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
