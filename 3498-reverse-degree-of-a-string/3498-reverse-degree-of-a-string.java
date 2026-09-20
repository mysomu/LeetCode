class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int revValue = 26 - (c - 'a');
            int position = i + 1;
            sum += revValue * position;
        }
        return sum;
    }
}