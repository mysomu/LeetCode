class Solution:
    def processStr(self, s: str) -> str:
        res = ""
        for ch in s:
            if ch == "*":
                # FIX: Safely remove up to two characters without using negative slicing
                res = res[:-1] if len(res) >= 2 else ""
            elif ch == "#":
                res = res + res
            elif ch == "%":
                res = res[::-1]
            else:
                res = res + ch
        return res
