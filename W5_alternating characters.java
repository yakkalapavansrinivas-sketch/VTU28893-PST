import java.io.*;
import java.util.*;

class Result {

    public static int alternatingCharacters(String s) {

        int count = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < q; i++) {

            String s = br.readLine().trim();

            int result = Result.alternatingCharacters(s);

            System.out.println(result);
        }

        br.close();
    }
}
