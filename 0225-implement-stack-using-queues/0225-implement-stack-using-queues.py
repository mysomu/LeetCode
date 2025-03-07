class MyStack:

    def __init__(self):
        self.s = []  # Using a list as a stack

    def push(self, x: int) -> None:
        self.s.append(x)

    def pop(self) -> int:
        # Return -1 if stack is empty
        return self.s.pop() if self.s else -1  

    def top(self) -> int:
        # Return top element, or -1 if empty
        return self.s[-1] if self.s else -1  

    def empty(self) -> bool:
        # Returns True if stack is empty, otherwise False
        return len(self.s) == 0  


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()