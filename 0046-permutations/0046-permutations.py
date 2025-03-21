class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtracking():
            if len(path) == len(nums):
                ans.append(path[:])
                return
            for i in range(len(nums)):
                if used[i] == 0:
                    path.append(nums[i])
                    used[i] += 1
                    backtracking()
                    path.pop()
                    used[i] -= 1
        
        ans = []
        used = [0] * len(nums)
        path = []
        backtracking()
        return ans