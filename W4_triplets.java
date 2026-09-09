import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aliceScore = 0;
        int bobScore = 0;

        int[] a = new int[3];
        int[] b = new int[3];

        // Read Alice's ratings
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }

        // Read Bob's ratings
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }

        // Compare ratings
        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                aliceScore++;
            } else if (a[i] < b[i]) {
                bobScore++;
            }
        }

        System.out.println(aliceScore + " " + bobScore);

        sc.close();
    }
}
