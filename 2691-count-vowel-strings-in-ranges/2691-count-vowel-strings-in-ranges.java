class Solution {
    public boolean isVowel(char ch) {
        String str = "aeiou";
        return str.indexOf(ch) != -1;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] Pre = new int[n];
        for (int i = 0; i < n; i++) {
            String temp = words[i];
            if (isVowel(temp.charAt(0)) && isVowel(temp.charAt(temp.length() - 1))) {
                Pre[i]++;
            }
        }
        for (int i = 1; i < n; i++) {
            Pre[i] += Pre[i - 1];
        }
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            if (l == 0) {
                ans[index++] = Pre[r];
            } else {
                ans[index++] = Pre[r] - Pre[l - 1];
            }
        }
        return ans;
    }
}