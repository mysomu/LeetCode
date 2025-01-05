from typing import List

class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)
        checked = [0] * (n + 1)  # Difference array for range updates
        for start, end, direction in shifts:
            checked[start] += 2 * direction - 1  # +1 for right, -1 for left
            checked[end + 1] -= 2 * direction - 1  # Reverse the shift after end+1
        shared = 0
        s = list(s)  # Convert to list for mutability
        for i in range(n):
            shared += checked[i]  # Compute cumulative shifts
            s[i] = chr(((ord(s[i]) - 97 + shared) % 26) + 97)  # Apply shift with wrap-around
        return ''.join(s)  # Return final string