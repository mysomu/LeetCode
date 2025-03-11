class Solution(object):
    def numberOfSubstrings(self, s):
        count = [0] * 3  
        left = 0  
        result = 0  
        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1  

            while count[0] > 0 and count[1] > 0 and count[2] > 0:
                result += len(s) - i  
                count[ord(s[left]) - ord('a')] -= 1  
                left += 1 
        return result