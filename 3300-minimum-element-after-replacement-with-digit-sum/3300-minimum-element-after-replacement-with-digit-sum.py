class Solution:
    def minElement(self, nums: List[int]) -> int:
        sum_of_nums = []
        for val in nums:
            sum=0
            while val>0:
                rem = val%10
                sum+=rem
                val //= 10
            sum_of_nums.append(sum)
        return min(sum_of_nums)

        