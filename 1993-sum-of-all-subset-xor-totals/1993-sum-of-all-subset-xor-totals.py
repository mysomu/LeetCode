class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        self.total = 0
        def dfs(idx:int, cur_xor:int):
            if idx == len(nums):
                self.total += cur_xor
                return
            #include cur num
            dfs(idx+1,cur_xor^nums[idx])
            #exclude curr num
            dfs(idx+1,cur_xor)
        dfs(0,0)
        return self.total