class Solution {
    Boolean[][] dp; // Memoization table to store intermediate results

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i); // Convert the square of i to a string
            dp = new Boolean[s.length()][1001]; // Reset the DP table for each number
            if (sol(s, 0, i)) { // Check if the square can be split into parts summing to i
                ans += i * i; // Add the valid squared number to the result
            }
        }
        return ans;
    }

    boolean sol(String s, int idx, int t) {
        if (idx == s.length()) {
            return t == 0; // If all digits are used and sum matches the target, return true
        }
        if (t < 0) return false; // If the sum exceeds the target, return false
        if (dp[idx][t] != null) {
            return dp[idx][t]; // Return memoized result if already computed
        }

        int val = 0;
        // Try forming different numbers by picking substrings starting from idx
        for (int j = idx; j < s.length(); j++) {
            val = val * 10 + (s.charAt(j) - '0'); // Convert substring to integer
            if (sol(s, j + 1, t - val)) { // Recursively check if the remaining sum matches
                return true;
            }
        }
        return dp[idx][t] = false; // Store and return false if no valid split is found
    }
}