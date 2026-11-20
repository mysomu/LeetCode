class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        n = len(nums)
        totalSum = sum(nums)

        # Left Sum
        leftSum = []
        left = totalSum

        for i in range(n - 1, -1, -1):
            left -= nums[i]
            leftSum.insert(0, left)

        # Right Sum
        rightSum = []
        right = totalSum

        for num in nums:
            right -= num
            rightSum.append(right)

        # Find Result
        result = [abs(rightSum[i] - leftSum[i]) for i in range(n)]

        return result