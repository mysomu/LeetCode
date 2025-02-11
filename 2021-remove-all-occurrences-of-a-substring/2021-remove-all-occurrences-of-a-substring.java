class Solution {
    private void calculateLPS(String part, int n, int[] lps) {
        int i = 0, j = 1;

        while (j < n) {
            if (part.charAt(i) == part.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }
        }
    }

    private void removeSubstrings(StringBuilder s, String part, int[] lps) {
        int m = s.length();
        int n = part.length();
        int i = 0; // for s
        int j = 0; // for part

        while (i < m) {
            if (s.charAt(i) == part.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) { // Found part match
                s.delete(i - n, i); // Remove substring
                m = s.length(); // Size of string will change
                i = Math.max(0, i - 2 * n); // Update start point
                j = 0;
            }
            if (i < m && s.charAt(i) != part.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
    }

    public String removeOccurrences(String s, String part) {
        int n = part.length();
        int[] lps = new int[n];
        Arrays.fill(lps, 0);

        calculateLPS(part, n, lps);
        StringBuilder sb = new StringBuilder(s);
        removeSubstrings(sb, part, lps);
        return sb.toString();
    }
}
