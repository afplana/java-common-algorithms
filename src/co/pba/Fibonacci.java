package co.pba;

import java.util.Scanner;

import static java.lang.String.format;

@SuppressWarnings("ALL")
public class Fibonacci {

    private Fibonacci(){}

    public static long recursive(int number) {
        return number <=1 ? 1 : recursive(number - 1) + recursive(number - 2);
    }


    public static long iterative(int number) {
        if (number  < 1)
            throw new IllegalArgumentException(format("Fibonacci can not be computed for %s", number));

        if (number == 1 || number == 2)
            return 1;

        int f1 = 1, f2 = 1, fibonacci = 1;
        for (var i = 3; i<=number; i++) {
            fibonacci = f1 + f2;
            f1=f2;
            f2=fibonacci;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        System.out.print("Enter number up to which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Fibonacci series up to " + number +" numbers : ");
        for(int i=1; i<=number; i++){ System.out.print(iterative(i) +" "); }
    }
}
