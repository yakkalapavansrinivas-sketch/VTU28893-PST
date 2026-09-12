import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int primarySum = 0;
        int secondarySum = 0;

        // Read matrix and calculate diagonal sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                // Primary diagonal
                if (i == j) {
                    primarySum += arr[i][j];
                }

                // Secondary diagonal
                if (i + j == n - 1) {
                    secondarySum += arr[i][j];
                }
            }
        }

        int difference = Math.abs(primarySum - secondarySum);

        System.out.println(difference);

        sc.close();
    }
}
