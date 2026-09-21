class Solution:
    def resultArray(self, nums: List[int], k: int) -> List[int]:

        n = len(nums)
        
        if k == 1:
            return [n * (n + 1)//2]

        nums = [num% k for num in nums]
        
        if k == 2:

            grps = groupby(nums)
            cnts = [len(list(grp)) for key, grp in grps if key != 0]
            odds = sum(c*(c+1) for c in cnts)//2
            return [(n * (n + 1))//2 - odds, odds]

        res, ctr, prvCtr = [0] * k, [0] * k, [0] * k
        
        for num in nums:  # for k = 3, 4, 5
            ctr[num]+= 1

            for i in range(k):
                ctr[(num * i) % k] += prvCtr[i]

            for i in range(k):
                res[i] += ctr[i]

            prvCtr, ctr = ctr, [0] * k 

        return res