class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if p == "":
            return s == ""
        ppoint = 0
        spoint = 0
        old_p = 0
        old_s = len(s)
        while True:
            if spoint == len(s):
                if ppoint == len(p):
                    return True
                
                if p[ppoint] != "*":
                    return False
                
                ppoint += 1
            elif ppoint == len(p):
                ppoint = old_p
                spoint = old_s
                old_s += 1
            elif p[ppoint] == "?":
                spoint += 1
                ppoint += 1
            elif p[ppoint] != "*":
                if p[ppoint] == s[spoint]:
                    ppoint += 1
                    spoint += 1
                else:
                    ppoint = old_p
                    spoint = old_s
                    old_s += 1
            else:
                ppoint += 1
                old_p = ppoint
                old_s = spoint

