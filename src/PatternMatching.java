import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

    //Brute-Force algorithm
    public static int findBrute(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        for (int i = 0; i <= n - m; i++) {
            int k = 0;
            while (k < m && text[i + k] == pattern[k]) {
                k++;
            }
            if (k == m) {
                return i;
            }
        }
        return -1;
    }

    //Boyer-Moore algorithm
    public static int findBoyerMoore(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) return 0;
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++)
            last.put(text[i], -1);
        for (int k = 0; k < m; k++)
            last.put(pattern[k], k);
        int i = m - 1;
        int k = m - 1;
        while (i < n) {
            if (text[i] == pattern[k]) {
                if (k == 0) return i;
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(text[i]));
                k = m - 1;
            }
        }
        return -1;
    }



    //KnutsMorris-Pratt algorithm
    public static int findKMP(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) return 0; 
        int[] fail = computeFailKMP(pattern); 
        int j = 0; 
        int k = 0; 
        while (j < n) {
            if (text[j] == pattern[k]) { 
                if (k == m - 1) return j - m + 1; 
                j++; 
                k++;
            } else if (k > 0)
                k = fail[k - 1]; 
            else
                j++;
        }
        return -1; 
    }

    private static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return fail;
    }

}
