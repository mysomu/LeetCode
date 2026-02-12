class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s)==0:
            return 0
        stack = [-1]
        max_length = 0
        for i,char in enumerate(s):
            if char=='(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    max_length = max(max_length, i-stack[-1])
        return max_length