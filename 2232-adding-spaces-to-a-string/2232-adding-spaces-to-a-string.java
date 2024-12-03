class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index = 0; // Pointer to traverse the original string
        
        for (int spaceIndex : spaces) {
            // Append the substring from the current index to the next space index
            result.append(s.substring(index, spaceIndex));
            result.append(" "); // Append a space
            index = spaceIndex; // Move the pointer forward
        }
        
        // Append the remaining part of the string
        result.append(s.substring(index));
        
        return result.toString();
    }
}
