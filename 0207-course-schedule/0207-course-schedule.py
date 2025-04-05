class Solution:
    def canFinish(self, n: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(n)]
        indegree = [0] * n
        ans = []

        for pair in prerequisites:
            course = pair[0]
            prerequisite = pair[1]
            adj[prerequisite].append(course)
            indegree[course] += 1

        stack = []
        for i in range(n):
            if indegree[i] == 0:
                stack.append(i)

        while stack:
            current = stack.pop()
            ans.append(current)

            for next_course in adj[current]:
                indegree[next_course] -= 1
                if indegree[next_course] == 0:
                    stack.append(next_course)

        return len(ans) == n