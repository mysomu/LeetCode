class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            ans += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }

        return ans;
    }
}