class Solution:
    def findNumbers(self, nums: list[int]) -> int:
        count = 0
        
        for num in nums:
            digit = 0
            n = num

            if n < 10:
                digit = 1
                continue

            while n > 0:
                n //= 10
                digit += 1

            if digit % 2 == 0:
                count += 1

        return count
        