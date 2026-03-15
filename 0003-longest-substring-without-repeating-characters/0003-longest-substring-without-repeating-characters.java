class Solution {
    public int lengthOfLongestSubstring(String s) {
       int left = 0, maxl = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxl = Math.max(maxl, right - left + 1);
        }
        return maxl;
    }
}