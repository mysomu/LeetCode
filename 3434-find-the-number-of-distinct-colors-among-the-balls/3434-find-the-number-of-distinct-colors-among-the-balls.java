class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // This map stores ball ---> color mapping
        Map<Integer, Integer> ballColors = new HashMap<>();
        // This Set stores distinct colors
        Map<Integer, Integer> colorFreq = new HashMap<>(); 
        // This list stores distinct colors after each query
        List<Integer> result = new ArrayList<>(); 

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];

            // If the ball already has a color then remove from distinct color
            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorFreq.put(oldColor, colorFreq.get(oldColor) - 1);

                if (colorFreq.get(oldColor) == 0) {
                    colorFreq.remove(oldColor);
                }
            }

            // Update the ball's color and add to distinctColors
            ballColors.put(ball, color);
            colorFreq.put(color, colorFreq.getOrDefault(color, 0) + 1);

            // // Store the current count of distinct colors
            result.add(colorFreq.size());
        }
        // Converting List<Integer> to int[]
        int output[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}