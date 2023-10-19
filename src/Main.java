import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum bound of prime numbers");
        int n = sc.nextInt();
        Sieve(n);

    }
    public static void Sieve(int n) {
        Queue<Integer> numberQueue = new LinkedList<>();
        Queue<Integer> primeQueue = new LinkedList<>();
        Queue<Integer> results = new LinkedList<>();


        for (int i = 2; i <=n; i++) {
            numberQueue.add(i);
        }
        while (!numberQueue.isEmpty()) {
            int temp = numberQueue.poll();
            primeQueue.offer(temp);

            int size = numberQueue.size();
            for (int i = 0; i < size; i++) {
                int x = numberQueue.poll();
                if (x % temp != 0) {
                    numberQueue.offer(x);
                }
            }
        }
        System.out.println("Primes up to " + n + ":");
        while (!primeQueue.isEmpty()) {
            results.offer(primeQueue.poll());
        }
        System.out.println(results);
    }
}
