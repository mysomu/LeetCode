class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            nums[i] += (1024 * (nums[nums[i]] % 1024))
        
        for i in range(len(nums)):
            nums[i] //= 1024
        
        return nums