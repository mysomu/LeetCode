class Solution {
    // Step 1: Define the backtracking function
    private void backtrack(int n, String curr, List<String> happyStrings) {
        // Step 2: If the current string reaches length 'n', store it and return
        if (curr.length() == n) {
            happyStrings.add(curr);
            return;
        }

        // Step 3: Iterate over possible characters ('a', 'b', 'c')
        for (char ch : new char[] { 'a', 'b', 'c' }) {
            // Step 4: Ensure the new character is different from the last one
            if (curr.isEmpty() || curr.charAt(curr.length() - 1) != ch) {
                // Step 5: Recursively generate the next character
                backtrack(n, curr + ch, happyStrings);
            }
        }
    }

    // Step 6: Main function to generate happy strings
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings); // Step 7: Start backtracking from an empty string

        // Step 8: Return k-th happy string if it exists, else return ""
        return (k > happyStrings.size()) ? "" : happyStrings.get(k - 1);
    }
}