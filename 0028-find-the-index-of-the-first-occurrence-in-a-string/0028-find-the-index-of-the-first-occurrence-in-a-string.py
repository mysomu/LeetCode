class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        len_haystack = len(haystack)
        len_needle = len(needle)
        for i in range(len_haystack-len_needle+1):
            if haystack[i:i+len_needle] == needle:
                return i
        return -1