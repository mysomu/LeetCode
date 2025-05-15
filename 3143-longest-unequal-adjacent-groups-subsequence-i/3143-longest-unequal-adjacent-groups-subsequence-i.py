class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        result = []
        last = -1
        for i in range(len(words)):
            if groups[i] != last:
                result.append(words[i])
                last = groups[i]
        return result 