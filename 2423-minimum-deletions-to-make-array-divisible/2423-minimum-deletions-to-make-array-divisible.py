# import math
class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        g = numsDivide[0]
        for i in range(1, len(numsDivide)):
            g = math.gcd(g, numsDivide[i])
        nums.sort()
        for i, num in enumerate(nums):
            if g % num == 0:
                return i
        return -1
