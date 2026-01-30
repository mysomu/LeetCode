class Solution:
    def majorityElement(self, nums: List[int]) -> int:
       maj = nums[0]
       count = 1
       for i in range(1,len(nums)):
        if maj == nums[i]:
            count += 1
        else:
            count -= 1
            if count==0:
                maj = nums[i]
                count = 1
       return maj
