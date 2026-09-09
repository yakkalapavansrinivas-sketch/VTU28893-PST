import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] freq = new int[26];

            // First half
            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // Starting index of second half
            int start = (n % 2 == 0) ? n / 2 : n / 2 + 1;

            // Second half
            for (int i = start; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean isLapindrome = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    isLapindrome = false;
                    break;
                }
            }

            System.out.println(isLapindrome ? "YES" : "NO");
        }

        sc.close();
    }
}
