class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        if rows == 0:
            return 0
        cols = len(grid[0])
        
        def markCurrentIsland(x: int, y: int):
            if x < 0 or x >= rows or y < 0 or y >= cols or grid[x][y] != '1':
                return
            # Mark current cell as visited
            grid[x][y] = '2'
            # Visit all adjacent cells (up, down, left, right)
            markCurrentIsland(x + 1, y)  # DOWN
            markCurrentIsland(x - 1, y)  # UP
            markCurrentIsland(x, y + 1)  # RIGHT
            markCurrentIsland(x, y - 1)  # LEFT

        noOfIslands = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    markCurrentIsland(i, j)
                    noOfIslands += 1

        return noOfIslands
