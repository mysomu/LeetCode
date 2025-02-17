class Solution {
    private int buildChar(int[] charCount) {
        int totalCount = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                totalCount++;
                charCount[i]--;
                totalCount += buildChar(charCount);
                charCount[i]++;
            }
        }
        return totalCount;
    }

    public int numTilePossibilities(String tiles) {
        int[] charCount = new int[26];
        for (char ch : tiles.toCharArray()) {
            charCount[ch - 'A']++;
        }
        return buildChar(charCount);
    }
}