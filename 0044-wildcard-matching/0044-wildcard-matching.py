class Solution:
    def isMatch(self, text: str, pattern: str) -> bool:
        n1, n2 = len(text), len(pattern)
        dp = [[False] * (n2 + 1) for _ in range(n1 + 1)]

        dp[0][0] = True

        # Handle the pattern for leading '*' characters
        for j in range(1, n2 + 1):
            if pattern[j - 1] == '*':
                dp[0][j] = dp[0][j - 1]

        # Fill the dp table
        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                if text[i - 1] == pattern[j - 1] or pattern[j - 1] == '?':
                    dp[i][j] = dp[i - 1][j - 1]
                elif pattern[j - 1] == '*':
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
                else:
                    dp[i][j] = False

        return dp[n1][n2]