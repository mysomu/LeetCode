class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n, m = len(word1), len(word2)
        #Initialise DP array
        dp = [[0] * (n+1) for _ in range(m+1)]
        #If i==0 assign number of characters in word1[0:j]
        for j in range(1, n+1):
            dp[0][j] = j
        #If j==0 assign number of characters in word2[0:i]
        for i in range(1, m+1):
            dp[i][0] = i

        for i in range(1, m+1):
            for j in range(1, n+1):
                #If chars matches
                if word2[i-1] == word1[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = 1 + min(
                        dp[i][j-1],
                        dp[i-1][j],
                        dp[i-1][j-1]
                    )
        return dp[m][n]