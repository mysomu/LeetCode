class Solution:
    def trailingZeroes(self, n: int) -> int:
        count = 0

        while n > 0:
            n = n // 5
            count = count + n

        return count