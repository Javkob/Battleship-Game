import java.util.Scanner;

class Main {
    /*
    You are given two 2D vectors. Find the angle (in degrees) between them.
    The first line contains two components of the first vector;
    the second line contains two components of the second vector.
    Components in one line are separated by space.
    Sample Input :
        1 3
        4 2

    Output data format
    One double value: an angle between two vectors. The result can have an error of less than 1e-8.
    Sample Output :
        45
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ux = scanner.nextInt();
        int uy = scanner.nextInt();
        int vx = scanner.nextInt();
        int vy = scanner.nextInt();
        System.out.println(Math.toDegrees(
                Math.acos((ux * vx + vy * uy) / (Math.hypot(ux, uy) * Math.hypot(vx, vy)))));
    }
}