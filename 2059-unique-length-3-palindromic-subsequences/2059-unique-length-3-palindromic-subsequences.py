class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        from collections import defaultdict
        
        char_indices = defaultdict(list)
        for i, char in enumerate(s):
            char_indices[char].append(i)
        
        ans = 0
        for indices in char_indices.values():
            start = indices[0]
            end = indices[-1]

            if end - start <= 1:
                continue
            
            seen = set()
            for i in range(start + 1, end):
                seen.add(s[i])
            
            ans += len(seen)
        
        return ans