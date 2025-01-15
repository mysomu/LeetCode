class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        set_bits = bin(num2).count('1')
        x = 0
        for i in range(31, -1, -1):
            if set_bits == 0:
                break
            if (num1 & (1 << i)) != 0:
                x |= (1 << i)
                set_bits -= 1
        for i in range(32):
            if set_bits == 0:
                break
            if (x & (1 << i)) == 0:
                x |= (1 << i)
                set_bits -= 1
        return x