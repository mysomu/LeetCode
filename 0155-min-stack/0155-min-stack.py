class MinStack:

    def __init__(self):
        self.stack = []
        self.Min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.Min_stack or val <= self.Min_stack[-1]:
            self.Min_stack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.Min_stack[-1]:
            self.Min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.Min_stack[-1]