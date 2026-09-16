import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] count = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int needed = p.length();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (count[c - 'a'] > 0) {
                needed--;
            }

            count[c - 'a']--;
            right++;

            // Window size becomes p.length()
            if (right - left == p.length()) {

                if (needed == 0) {
                    result.add(left);
                }

                char remove = s.charAt(left);

                count[remove - 'a']++;

                if (count[remove - 'a'] > 0) {
                    needed++;
                }

                left++;
            }
        }

        return result;
    }
}
