import java.util.*;

public class Solution {
    public int longestBalanced(String s) {
        int maxLen = 0;

        maxLen = Math.max(maxLen, getMaxSingle(s, 'a'));
        maxLen = Math.max(maxLen, getMaxSingle(s, 'b'));
        maxLen = Math.max(maxLen, getMaxSingle(s, 'c'));

        maxLen = Math.max(maxLen, getMaxDouble(s, 'a', 'b', 'c'));
        maxLen = Math.max(maxLen, getMaxDouble(s, 'a', 'c', 'b'));
        maxLen = Math.max(maxLen, getMaxDouble(s, 'b', 'c', 'a'));

        maxLen = Math.max(maxLen, getMaxTriple(s));

        return maxLen;
    }

    private int getMaxSingle(String s, char target) {
        int max = 0, current = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == target) current++;
            else current = 0;
            max = Math.max(max, current);
        }
        return max;
    }

    private int getMaxDouble(String s, char c1, char c2, char forbidden) {
        int n = s.length();
        int max = 0;
        int diff = 0;
        
        int[] firstSeen = new int[2 * n + 1];
        int[] version = new int[2 * n + 1];
        int curVersion = 1;

        firstSeen[n] = -1; 
        version[n] = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == forbidden) {
                curVersion++;
                diff = 0;
                version[n] = curVersion;
                firstSeen[n] = i; 
            } else {
                if (c == c1) diff++;
                else if (c == c2) diff--;
                
                int index = diff + n; 
                
                if (version[index] == curVersion) {
                    max = Math.max(max, i - firstSeen[index]);
                } else {

                    firstSeen[index] = i;
                    version[index] = curVersion;
                }
            }
        }
        return max;
    }

    private int getMaxTriple(String s) {
        int n = s.length();
        int max = 0;
        int diff1 = 0, diff2 = 0; 
        
        Map<Long, Integer> firstSeen = new HashMap<>();
        long initialKey = 0L;
        firstSeen.put(initialKey, -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') { diff1++; }
            else if (c == 'b') { diff1--; diff2++; }
            else if (c == 'c') { diff2--; }

            long key = (((long)diff1) << 32) | (diff2 & 0xFFFFFFFFL);

            if (firstSeen.containsKey(key)) {
                max = Math.max(max, i - firstSeen.get(key));
            } else {
                firstSeen.put(key, i);
            }
        }
        return max;
    }
}