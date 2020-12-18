import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
    Read an input text from the console and print its characters in reversed order.
    Use Reader for collecting characters.
     Sample Input 1:
     abc
     Sample Output 1:
     cba
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reader.readLine());
        stringBuilder.reverse();
        reader.close();
        System.out.println(stringBuilder.toString());
    }
}