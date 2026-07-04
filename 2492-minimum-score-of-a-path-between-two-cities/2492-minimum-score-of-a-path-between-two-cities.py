class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        graph = [[] for _ in range(n + 1)]

        for a, b, distance in roads:
            graph[a].append((b, distance))
            graph[b].append((a, distance))

        visited = [False] * (n + 1)

        queue = deque([1])
        visited[1] = True

        answer = float("inf")

        while queue:
            city = queue.popleft()

            for next_city, distance in graph[city]:
                answer = min(answer, distance)

                if not visited[next_city]:
                    visited[next_city] = True
                    queue.append(next_city)

        return answer