import java.util.Arrays;
import java.util.Scanner;

public class Kelement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        Arrays.sort(arr);

        System.out.println("Kth smallest element = " + arr[k - 1]);
    }
}