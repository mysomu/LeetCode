class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        ans = []
        output = ""
        index = 0
        mapping = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        self.backtrack(digits,output,index,ans,mapping)
        return ans

    def backtrack(self,digits,output,index,ans,mapping):
        #base case
        if index>=len(digits):
            ans.append(output)
            return
        num = int(digits[index])
        value = mapping[num]
        for char in value:
            self.backtrack(digits,output+char,index+1,ans,mapping)