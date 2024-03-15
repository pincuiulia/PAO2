import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N (the position in the Fibonacci sequence): ");
        int N = scanner.nextInt();
        System.out.println("The " + N + "th number in the Fibonacci sequence is: " + fibonacci(N));
    }

    public static int fibonacci(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fibonacci(N - 1) + fibonacci(N - 2);
        }
    }
}
