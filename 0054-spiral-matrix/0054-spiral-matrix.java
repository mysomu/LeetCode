class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            // right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}