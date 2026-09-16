import java.util.*;

class Result {

    public static String twoStrings(String s1, String s2) {
        boolean[] present = new boolean[26];

        for (char c : s1.toCharArray()) {
            present[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (present[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        while (p-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(Result.twoStrings(s1, s2));
        }

        sc.close();
    }
}
