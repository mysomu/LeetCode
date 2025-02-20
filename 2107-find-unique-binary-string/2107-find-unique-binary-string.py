class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums[0])
        numSet = set(nums)

        def generateBinary(binary):
            if len(binary) == n:
                if binary not in numSet:
                    return binary
                return None
            res = generateBinary(binary + '0')
            if res: return res
            return generateBinary(binary + '1')

        return generateBinary("")