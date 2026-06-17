class Solution:
    def processStr(self, s: str, k: int) -> str:
        lengths = [0]
        for ch in s:
            cur = lengths[-1]
            if ch == '*':
                cur = max(0, cur - 1)
            elif ch == '#':
                cur *= 2
            elif ch == '%':
                pass  # length unchanged
            else:
                cur += 1
            lengths.append(cur)
        if k >= lengths[-1]:
            return '.'
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            cur = lengths[i + 1]
            prev = lengths[i]
            if ch == '#':
                if k >= prev:
                    k -= prev
            elif ch == '%':
                k = prev - 1 - k
            elif ch == '*':
                pass
            else:
                if k == prev:
                    return ch
        return '.'
        