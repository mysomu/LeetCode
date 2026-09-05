class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        max_v = float('-inf')
        min_v = [0]*len(nums)
        min_v[-1]=nums[-1]
        for i in range(len(nums)-2,-1,-1):
            min_v[i] = min(nums[i],min_v[i+1])
        for j in range(len(nums)):
            max_v = max(max_v,nums[j])
            if max_v-min_v[j]<=k:
                return j
        return -1

