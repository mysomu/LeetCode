class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m = len(mat)
        n = len(mat[0])
        ln = len(arr)
        index = [[0, 0] for _ in range(0, ln+1)]
        row = [0] * m
        col = [0] * n
        for i in range (0, m):
            for j in range (0, n):
                val = mat[i][j]
                index[val][0] = i
                index[val][1] = j
        res=0
        for i in range (0, ln):
            val = arr[i]
            row[index[val][0]]+=1
            col[index[val][1]]+=1
            res+=1
            if row[index[val][0]]==n or col[index[val][1]]==m:
                return res-1
        return res-1