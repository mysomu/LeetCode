class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(remaining, combination, start):
            if remaining == 0:
                result.append(list(combination))
                return
            if remaining < 0:
                return

            for i in range(start, len(candidates)):
                combination.append(candidates[i])
                backtrack(remaining - candidates[i], combination, i)
                combination.pop()

        result = []
        backtrack(target, [], 0)
        return result