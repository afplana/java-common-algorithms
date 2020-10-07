package co.pba;

import java.util.Scanner;

public class Palindrome {

    private static boolean recursive(String word) {
        if (word == null || word.isEmpty())
            return false;
        if (word.length() == 1)
            return true;
        if (word.length() == 2 && word.charAt(0) == word.charAt(1))
            return true;
        else if (word.charAt(0) == word.charAt(word.length()-1))
            return recursive(word.substring(1,word.length()-1));

        return false;
    }

    private static boolean iterative(String word) {
        if (word == null || word.isEmpty()) return false;
        if (word.length() == 1) return true;

        int middle = word.length()/2;
        var odd = word.length()%2 != 0;
        var half1 = word.substring(0, middle);
        var half2 = word.substring(odd ? middle+1:middle);
        half2 = new StringBuilder(half2).reverse().toString();
        for (var i = 0; i < middle; i++) {
            if (half1.charAt(i) != half2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter word to verify if palindrome: ");
        var scanner = new Scanner(System.in);
        var word = scanner.nextLine();
        while (!word.equals("exit")) {
            System.out.println(recursive(word));
            System.out.println(iterative(word));
            System.out.println();
            System.out.print("Enter word to verify if palindrome: ");
            word = scanner.nextLine();
        }

    }
}
