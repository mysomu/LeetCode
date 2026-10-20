class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        cumulative_sum = []
        a = 0
        for i in range(len(nums)):
            a = a + nums[i]
            cumulative_sum.append(a)
        return cumulative_sum