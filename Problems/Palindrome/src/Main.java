import java.util.Scanner;
/*
    Write a program that reads a string and checks whether it is a palindrome, i.e. it reads the same both left-to-right and right-to-left.
    The program must output “yes” if the string is a palindrome and “no” otherwise.

    Sample Input:
    kayak

    Sample Output:
    yes
 */
class Main {
    public static void main(String[] args) {
        String palindrome = new Scanner(System.in).nextLine();
        System.out.println((new StringBuilder(palindrome).reverse().toString().equals(palindrome)) ? "yes" : "no");
    }
}