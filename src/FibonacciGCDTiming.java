import java.util.concurrent.TimeUnit;

public class FibonacciGCDTiming {//task 22.6
    public static void main(String[] args) {
        System.out.println("Index\tFibonacci(n)\tFibonacci(n+1)\tGCD\tTime (ms)");
        System.out.println("---------------------------------------------------");
        for (int i = 40; i <= 45; i++) {
            long startTime = System.currentTimeMillis();
            long fibN = fibonacci(i);
            long fibNPlus1 = fibonacci(i + 1);
            long gcd = gcd(fibN, fibNPlus1);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.println(i + "\t" + fibN + "\t\t" + fibNPlus1 + "\t\t" + gcd + "\t" + time);
        }
    }
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long fib1 = 0, fib2 = 1;
        for (int i = 2; i <= n; i++) {
            long temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return fib2;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
