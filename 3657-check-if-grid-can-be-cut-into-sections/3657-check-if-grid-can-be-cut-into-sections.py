class Solution(object):
    def checkValidCuts(self, n, rectangles):
        return self.isValidCut(rectangles, 0, 0, 2) or self.isValidCut(rectangles, 1, 1, 3)

    def isValidCut(self, rectangles, sort_index, start, end):
        rectangles.sort(key=lambda x: x[sort_index])
        
        current_start = rectangles[0][start]
        current_end = rectangles[0][end]
        intervals = 0

        for rect in rectangles:
            if rect[start] < current_end:
                current_end = max(rect[end], current_end)
            else:
                intervals += 1
                current_start = rect[start]
                current_end = rect[end]
        
        intervals += 1
        return intervals > 2