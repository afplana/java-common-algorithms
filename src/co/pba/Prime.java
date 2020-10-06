package co.pba;

import java.util.Scanner;

public class Prime {

    public static boolean verify(int number) {
        if (number == 2 || number == 3) return true;
        if (number%2 == 0 || number%3 == 0) return false;
        int sqrt = (int) Math.sqrt(number) + 1;
        for ( int i = 3; i<sqrt ; i +=2 ) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter to verify primality: ");
        int number = new Scanner(System.in).nextInt();
        System.out.print(verify(number));
    }
}
