class Solution:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        mp = defaultdict(list)
        pq = []
        ans = [-1]*len(queries)

        for i,q in enumerate(queries):
            l,r = sorted(q)

            if l==r or heights[r]> heights[l]:
                ans[i] = r
            else:
                h = max(l,r)
                mp[r].append((max(heights[r],heights[l]), i))
            
        
        for i,h in enumerate(heights):

            for q_h,q_i in mp[i]:
                heapq.heappush(pq,(q_h,q_i))
            
            while pq and h> pq[0][0]:
                q_h,q_i = heapq.heappop(pq)
                ans[q_i] = i

        return ans
        