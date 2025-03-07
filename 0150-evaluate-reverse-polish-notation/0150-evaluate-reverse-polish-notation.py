class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == '+':
                stack.append(stack.pop() + stack.pop())                
            elif token == "-":
                b = stack.pop()
                a = stack.pop()
                stack.append(a-b)
            elif token == "*":
                b, a = stack.pop(), stack.pop()
                stack.append(a*b)
            elif token == "/":
                b,a=stack.pop(), stack.pop()
                stack.append(int(a/b))
            else:
                stack.append(int(token))
                
        return stack.pop()