import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped array

        // Traverse the pushed array
        for (int x : pushed) {
            stack.push(x); // simulate push operation
            // check if top of the stack matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop(); // simulate pop operation
                j++; // move to the next element in the popped array
            }
        }

        // If the stack is empty, it means the sequence is valid
        return stack.isEmpty();
    }
}
