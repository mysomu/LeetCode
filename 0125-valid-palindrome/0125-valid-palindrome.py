class Solution(object):
    def isPalindrome(self, s):
        new = ""
        for i in s:
            if i.isalnum():
                new += i.lower()
        return new == new[::-1]