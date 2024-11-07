class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        mx_len = 0

        for i in range(24):
            x = 1 << i  # Create a bitmask with only the i-th bit set
            # Count numbers with the i-th bit set
            cnt = sum(1 for num in candidates if num & x)
            mx_len = max(mx_len, cnt)

        return mx_len
