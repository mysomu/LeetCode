class Solution:
    def clearDigits(self, s: str) -> str:
        om = []
        for c in s:
            if "0" <= c <= "9":
                if om:  # Check if om is not empty
                    om.pop()  # Remove the last character
            else:
                om.append(c)  # Append the character if it's not a digit
        return "".join(om)  # Join the list into a string and return it
