class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        n = len(nums)
        res = []
        mid = n//2
        for i in range(mid):
            res.append(nums[i])
            res.append(nums[mid+i])
        return res