public class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && x == ')') {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minAddToMakeValid("())")); // Example usage
    }
}