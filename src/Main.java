// import the Scanner/Queue classes
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner sc = new Scanner(System.in);
        // initialize variable n, set it to 1. This is so that it doesn't have an initial value of 0, thereby preventing the program from running, but also not being a prime
        int n  = 1;
        // utilizing a do while loop to run the program at least one time, and then continuing to do so while n is not equal to 0 (exit condition)
        do {
            System.out.println("Enter the maximum bound of prime numbers. Enter 0 to exit the program.");
            // take the user input
            n = sc.nextInt();
            // passing the user input into the Sieve method
            Sieve(n);
        }
        while (n != 0);
        // inform the user that the program is ending
        System.out.println("Program terminated");
    }
    public static void Sieve(int n) {
        // initializing three queues: one to hold the total numbers from 2 to n, one to hold the prime numbers, and one to output the results neatly
        Queue<Integer> numberQueue = new LinkedList<>();
        Queue<Integer> primeQueue = new LinkedList<>();
        Queue<Integer> results = new LinkedList<>();

        for (int i = 2; i <=n; i++) {
            // populating the number queue
            numberQueue.add(i);
        }
        // if n is 0 there's no reason to output an empty line
        if (n!=0) {
            while (!numberQueue.isEmpty()) {
                int temp = numberQueue.poll();
                // temporarily placing the numberqueue value into the primequeue
                primeQueue.offer(temp);

                int size = numberQueue.size();
                // traversing through the number queue, removing non-prime numbers
                for (int i = 0; i < size; i++) {
                    int x = numberQueue.poll();
                    if (x % temp != 0) {
                        numberQueue.offer(x);
                    }
                }
            }
            // reminding the user what's being outputted
            System.out.println("Primes up to " + n + ":");
            while (!primeQueue.isEmpty()) {
                results.offer(primeQueue.poll());
            }
            // printing the results
            System.out.println(results);
        }
        // if n = 0, don't implement the preceding code and simply return
        else return;
    }
}
