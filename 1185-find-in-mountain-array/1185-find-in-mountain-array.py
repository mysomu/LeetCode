# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
#class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        def binary_search(l, r, key, asc=True):
            while l <= r:
                mid = (l + r) // 2
                val = mountainArr.get(mid)
                if val == key:
                    return mid
                if (val < key) == asc:
                    l = mid + 1
                else:
                    r = mid - 1
            return -1

        n = mountainArr.length()
        
        # Find peak element
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) // 2
            if mountainArr.get(mid) < mountainArr.get(mid + 1):
                left = mid + 1
            else:
                right = mid
        peak = left

        # Search in the left (ascending) part
        res = binary_search(0, peak, target, True)
        if res != -1:
            return res

        # Search in the right (descending) part
        return binary_search(peak + 1, n - 1, target, False)
