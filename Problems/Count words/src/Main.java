import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/*
    Read an input text from the console and print the number of words. By word we mean a sequence of characters separated by one or several spaces.
    If the input is empty or there are no characters except spaces, print 0.

        Sample Input:
        one two three

        Sample Output:
        3
 */
class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = ((BufferedReader) reader).readLine();
            int result = line.isBlank() ? 0 : line.trim().split("\\s+").length;
            System.out.println(result);
        }
    }
}