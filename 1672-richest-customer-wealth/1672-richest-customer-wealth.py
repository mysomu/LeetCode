class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        m = len(accounts)
        n = len(accounts[0])
        maxSum = 0
        for i in range(m):
            sum=0
            for j in range(n):
                sum += accounts[i][j]
            maxSum = max(sum,maxSum)
        return maxSum

