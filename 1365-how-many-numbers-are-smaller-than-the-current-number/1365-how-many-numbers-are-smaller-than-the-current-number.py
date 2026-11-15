class Solution:
    def smallerNumbersThanCurrent(self, nums: list[int]) -> list[int]:
       return [sorted(nums).index(i) for i in nums]