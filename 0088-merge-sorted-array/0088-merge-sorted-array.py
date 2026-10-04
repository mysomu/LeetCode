class Solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        for j in range(n):
            nums1[m+j] = nums2[j]
        nums1.sort()
        