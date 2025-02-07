from collections import Counter


class Solution:
    def queryResults(self, limit: int, queries: list[list[int]]) -> list[int]:
        res = []
        ball_map = {}
        color_freq = Counter()

        for ball, color in queries:
            if ball in ball_map:
                old_color = ball_map[ball]
                color_freq[old_color] -= 1
                if color_freq[old_color] == 0:
                    del color_freq[old_color]

            ball_map[ball] = color
            color_freq[color] += 1

            res.append(len(color_freq))

        return res
