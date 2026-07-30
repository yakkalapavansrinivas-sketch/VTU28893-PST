import java.util.Scanner;

public class Index {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        if(index >= 0 && index < n) {
            System.out.println("Element at index " + index + " = " + arr[index]);
        } else {
            System.out.println("Invalid Index");
        }
    }
}