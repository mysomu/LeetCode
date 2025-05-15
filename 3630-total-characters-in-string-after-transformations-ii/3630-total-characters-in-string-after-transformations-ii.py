MOD = 10**9 +7
def multiply(a,b):
    new_matrix = [[0]*26 for _ in range(26)]
    for i in range(26):
        for j in range(26):
            for k in range(26):
                new_matrix[i][j] = (new_matrix[i][j] + a[i][k]*b[k][j]) %MOD
    return new_matrix

def pow_matrix(base,exp):
    new_matrix = [[0]*26 for _ in range(26)]
    for i in range(26): new_matrix[i][i] = 1
    while exp:
        if exp % 2: new_matrix = multiply(new_matrix, base)
        base = multiply(base,base)
        exp //= 2
    return new_matrix

class Solution:
    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        matrix = [[0]*26 for _ in range(26)]
        for i in range(26):
            for j in range(1,nums[i]+1):
                matrix[(i+j)%26][i] = 1

        final_matrix = pow_matrix(matrix, t)
        map = [0]*26
        for x in s: map[ord(x) - ord('a')] +=1
        res = [0] * 26
        for i in range(26):
            for j in range(26):
                res[i]= (res[i] + final_matrix[i][j] * map[j]) % MOD
        return sum(res) % MOD