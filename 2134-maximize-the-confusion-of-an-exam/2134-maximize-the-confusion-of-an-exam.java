class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // Return the maximum of consecutive substrings of 'T' and 'F'
        return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
    }
    
    public int helper(String s, int k, char ch) {
        int sp = 0; // Start pointer
        int ep = 0; // End pointer
        int ans = 0; // Maximum length of consecutive substring
        
        while (ep < s.length()) {
            char currch = s.charAt(ep); // Current character at the end pointer
            
            if (currch != ch) {
                k--; // Decrement replacements count if current character is not the target character
            }
            
            // Handle case when the number of replacements is exceeded
            while (k < 0) {
                if (s.charAt(sp) == ch) {
                    sp++; // Move start pointer forward if the character at start is the target character
                } else {
                    k++; // Increment replacements count if the character at start is not the target character
                    sp++; // Move start pointer forward
                }
            }
            
            ans = Math.max(ans, ep - sp + 1); // Update the maximum length of consecutive substring
            ep++; // Move end pointer forward
        }
        
        return ans; // Return the maximum length of consecutive substring
    }
}
