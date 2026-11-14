
class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        res = []

        for i in range(len(nums)):
            leftSum = sum(nums[:i])
            rightSum = sum(nums[i+1:])

            res.append(abs(leftSum - rightSum))

        return res
