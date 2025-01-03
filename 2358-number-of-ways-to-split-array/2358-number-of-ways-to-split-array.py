class Solution:
    def waysToSplitArray(self, a: List[int]) -> int:
        return sum(map(ge,accumulate(a),accumulate(a[1:-1],sub,initial=sum(a[1:]))))