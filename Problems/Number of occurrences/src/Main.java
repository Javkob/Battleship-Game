import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
    Write a program that finds the frequency of occurrences of a substring in a given string. Substrings cannot overlap: for example, the string ababa contains only one substring aba.
    Input data format
    The first input line contains a string, the second one contains a substring.

     Sample Input 1:
     ababa
     aba

     Sample Output 1:
     1
 */
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String inputSubstring = scanner.nextLine();
        Pattern pattern = Pattern.compile(inputSubstring);
        Matcher matcher = pattern.matcher(inputString);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println(count);


    }
}