class Solution:
    def minOperations(self, g: List[List[int]], x: int) -> int:
        if any(abs(v-u)%x for v,u in pairwise(chain(*g))): return -1
        return sum(map(abs,map(sub,chain(*g),repeat(median_low(chain(*g))))))//x