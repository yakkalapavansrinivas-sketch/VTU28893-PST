import java.util.*;

class Result {

    public static int marsExploration(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 3 == 1) {
                expected = 'O';
            } else {
                expected = 'S';
            }

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(Result.marsExploration(s));

        sc.close();
    }
}
