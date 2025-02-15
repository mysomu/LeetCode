class Solution:
    def longestPrefix(self, s: str) -> str:
        i = len(s)-1
        while i>0:
            if s[:i]==s[-i:]:
                return s[:i]
            i -= 1
        return ""