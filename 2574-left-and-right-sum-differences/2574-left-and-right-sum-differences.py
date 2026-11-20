class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        totalSum = sum(nums)
        leftSum = 0
        result = []

        for num in nums:
            rightSum = totalSum - leftSum - num
            result.append(abs(leftSum - rightSum))
            leftSum += num

        return result