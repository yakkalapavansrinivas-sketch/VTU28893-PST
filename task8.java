import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        if (n == 0) {
            System.out.println("Nth Fibonacci = " + a);
        } 
        else if (n == 1) {
            System.out.println("Nth Fibonacci = " + b);
        } 
        else {

            int c = 0;

            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }

            System.out.println("Nth Fibonacci = " + c);
        }
    }
}