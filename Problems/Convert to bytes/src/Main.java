import java.io.InputStream;

/*
    Read an input text from the console and print it as a sequence of bytes.
    Use System.in as input stream directly. Avoid using Scanner.
     Sample Input 1:
     abc
     Sample Output 1:
     979899
 */
class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        for (int i : inputStream.readAllBytes()) {
            System.out.print(i);
        }
    }
}