class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());}
        boolean reverse = false;
        int index = 0;
        for (char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (reverse) {
                index--;
            } else {
                index++;
            }
            if (index == 0 || index == numRows - 1) {
                reverse = !reverse;
            }}
        StringBuilder output = new StringBuilder();
        for (StringBuilder row : rows) {
            output.append(row);}
        return output.toString();
    }}