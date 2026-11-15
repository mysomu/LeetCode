class Solution:
    def smallerNumbersThanCurrent(self, nums: list[int]) -> list[int]:
        sorted_nums = sorted(nums)
        mapping = {}
        for i, num in enumerate(sorted_nums):
            if num not in mapping:
                mapping[num] = i
        return [mapping[num] for num in nums]