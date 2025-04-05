import math
from typing import List


class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        n = len(roads) + 1
        adj = [[] for _ in range(n)]

        for u, v in roads:
            adj[u].append(v)
            adj[v].append(u)

        total_fuel = 0

        def dfs(node: int, parent: int) -> int:
            nonlocal total_fuel
            people = 1

            for child in adj[node]:
                if child != parent:
                    people += dfs(child, node)

            if node != 0:
                total_fuel += math.ceil(people / seats)

            return people

        dfs(0, -1)
        return total_fuel
