class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if not s:
            return s
        
        rev_s = s[::-1]
        new_s = s + "#" + rev_s
        lps = [0] * len(new_s)

        # Compute LPS (Longest Prefix Suffix) array for KMP algorithm
        j = 0
        for i in range(1, len(new_s)):
            while j > 0 and new_s[i] != new_s[j]:
                j = lps[j - 1]
            if new_s[i] == new_s[j]:
                j += 1
            lps[i] = j

        # Find the longest palindrome prefix
        longest_palindrome_prefix_length = lps[-1]
        suffix_to_add = rev_s[:len(s) - longest_palindrome_prefix_length]
        
        return suffix_to_add + s
