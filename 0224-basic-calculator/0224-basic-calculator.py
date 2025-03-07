class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        result = 0
        number = 0
        sign = 1  # 1 for positive, -1 for negative

        for i in range(len(s)):
            char = s[i]

            if char.isdigit():
                number = 10 * number + int(char)
            
            elif char == '+':
                result += sign * number
                number = 0
                sign = 1  # Next number should be positive
            
            elif char == '-':
                result += sign * number
                number = 0
                sign = -1  # Next number should be negative
            
            elif char == '(':
                stack.append(result)
                stack.append(sign)
                result = 0
                sign = 1
            
            elif char == ')':
                result += sign * number
                number = 0
                result *= stack.pop()  # Multiply by sign before '('
                result += stack.pop()  # Add previous result before '('
        
        # If there's a remaining number, add it to the result
        if number != 0:
            result += sign * number
        
        return result
