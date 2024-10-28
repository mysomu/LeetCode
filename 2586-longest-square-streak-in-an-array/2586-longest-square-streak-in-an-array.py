class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        num_set = set(nums)
        streak_lengths = {}
        max_length = -1

        for num in sorted(num_set):
            if num not in streak_lengths:
                current_length = 1
                next_num = num * num
                
                while next_num in num_set:
                    current_length += 1
                    streak_lengths[next_num] = current_length
                    next_num *= next_num
                
                if current_length > 1:
                    max_length = max(max_length, current_length)

        return max_length