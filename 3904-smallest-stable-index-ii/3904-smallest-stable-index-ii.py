class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        n = len(nums)

        min_v = [0] * n
        min_v[-1] = nums[-1]

        for i in range(n - 2, -1, -1):
            min_v[i] = min(nums[i], min_v[i + 1])

        max_v = nums[0]

        for i in range(n):
            max_v = max(max_v, nums[i])

            if max_v - min_v[i] <= k:
                return i

        return -1