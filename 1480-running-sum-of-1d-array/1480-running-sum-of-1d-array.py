class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        cumulative_sum = list(itertools.accumulate(nums))
        return cumulative_sum