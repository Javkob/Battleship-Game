package battleship;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        UserInput userInput = new UserInput();
        Map map = new Map(10,10);
        userInput.enterCoordinates("Aircraft Carrier",5);
            map.display();
            map.markShip("A",1,"D",1);
            map.display();

    }
}
