class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        #find gcd for numsDivide
        gcd_val = numsDivide[0]
        for i in range(1,len(numsDivide)):
            gcd_val = math.gcd(gcd_val,numsDivide[i])
        nums.sort()
        for num in nums:
            if gcd_val%num==0:
                return nums.index(num)
        return -1