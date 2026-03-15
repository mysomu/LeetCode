class Solution:
    def isValidSudoku(self, g: List[List[str]]) -> bool:
        return len(q:=sum(([(v,i),(j,v),(i//3,j//3,v)] for i,j in product(*[range(9)]*2) if (v:=g[i][j])!='.'),[]))==len({*q})