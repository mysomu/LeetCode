class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        c = defaultdict(int)
        ans = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                pr = nums[i] * nums[j]
                ans += c[pr]
                c[pr] += 1
        return ans << 3
