class Solution {
    int[][] dp;
    int[] prefix;
    int[] a;

    int solve(int l, int r) {
        if (l >= r)
            return 0;

        if (dp[l][r] != -1)
            return dp[l][r];

        int ans = 0;
        int leftSum = 0;
        int rightSum = prefix[r + 1] - prefix[l];

        for (int k = l; k < r; ++k) {
            leftSum += a[k];
            rightSum -= a[k];

            if (leftSum < rightSum) {
                if (ans >= 2 * leftSum)
                    continue;

                ans = Math.max(ans, leftSum + solve(l, k));
            }
            else if (leftSum > rightSum) {
                if (ans >= 2 * rightSum)
                    break;

                ans = Math.max(ans, rightSum + solve(k + 1, r));
            }
            else {
                ans = Math.max(ans,
                    Math.max(
                        leftSum + solve(l, k),
                        rightSum + solve(k + 1, r)
                    )
                );
            }
        }

        return dp[l][r] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        a = stoneValue;
        int n = a.length;

        prefix = new int[n + 1];

        for (int i = 0; i < n; ++i)
            prefix[i + 1] = prefix[i] + a[i];

        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, n - 1);
    }
}