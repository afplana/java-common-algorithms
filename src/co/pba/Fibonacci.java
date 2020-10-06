package co.pba;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.String.format;

@SuppressWarnings("ALL")
public class Fibonacci {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    private Fibonacci(){}

    public static long recursive(int number) {
        if (number  < 1)
            throw new IllegalArgumentException(format("Fibonacci can not be computed for %s", number));

        return number == 1 || number ==2 ? 1 : recursive(number - 1) + recursive(number - 2);
    }


    public static long iterative(int number) {
        if (number  < 1)
            throw new IllegalArgumentException(format("Fibonacci can not be computed for %s", number));

        if (cache.containsKey(number))
            return cache.get(number);
        else {
            if (number == 1 || number == 2) return 1;

            int f1 = 1, f2 = 1, fibonacci = 1;

            for (var i = 3; i<=number; i++) {
                fibonacci = f1 + f2;
                f1=f2;
                f2=fibonacci;
            }

            cache.put(number, fibonacci);
        }
        return cache.get(number);
    }

    public static void main(String[] args) {
        System.out.print("Enter number up to which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Fibonacci series up to " + recursive(number) +" numbers : ");
        for(int i=1; i<=number; i++){ System.out.print(iterative(i) +" "); }
    }
}
