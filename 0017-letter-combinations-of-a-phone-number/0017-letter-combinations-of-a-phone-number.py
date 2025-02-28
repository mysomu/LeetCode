class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        phone = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        res = []

        def backtrack(digits,combination):
            if not digits:
                res.append(combination)
                return
            for letter in phone[digits[0]]:
                backtrack(digits[1:],combination+letter)

        backtrack(digits,"")
        return res
        