import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        
        Set<Character> vowels = new HashSet<>();
        String vowelLetters = "aeiouAEIOU";
        
        for (char c : vowelLetters.toCharArray()) {
            vowels.add(c);
        }

        int mid = s.length() / 2;
        int countA = 0;
        int countB = 0;

        // Count vowels in first half
        for (int i = 0; i < mid; i++) {
            if (vowels.contains(s.charAt(i))) {
                countA++;
            }
        }

        // Count vowels in second half
        for (int i = mid; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                countB++;
            }
        }

        return countA == countB;
    }
}
