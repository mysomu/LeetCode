class Solution:
    def stoneGameIX(self, a: List[int]) -> bool:
        z = Counter(v%3 for v in a)
        return (z[1]>0<z[2],abs(z[1]-z[2])>2)[z[0]&1]