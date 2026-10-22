class Solution:
    def findNumbers(self, nums: list[int]) -> int:
        count =0

        for num in nums:
            digit = str(num)
            if len(digit) % 2 == 0:
                count +=1
        return count