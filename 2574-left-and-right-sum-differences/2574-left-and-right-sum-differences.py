class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        ans = []
        sumR = sum(nums)
        sumL = 0
        for n in nums:
            sumR -= n
            ans.append(abs(sumL - sumR))
            sumL += n
        return ans
        