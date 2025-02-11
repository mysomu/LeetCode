class Solution {
    public String removeOccurrences(String str, String part) {
        char[] input = str.toCharArray();
        char[] target = part.toCharArray();
        char[] resultStack = new char[input.length];
        int targetLength = target.length;
        int stackSize = 0;
        char targetEndChar = target[targetLength - 1];

        for (char currentChar : input) {
            resultStack[stackSize++] = currentChar;

            if (currentChar == targetEndChar && stackSize >= targetLength) {
                int i = stackSize - 1, j = targetLength - 1;

                while (j >= 0 && resultStack[i] == target[j]) {
                    i--;
                    j--;
                }

                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }

        return new String(resultStack, 0, stackSize);
    }
}
