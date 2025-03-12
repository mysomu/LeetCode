class Solution:
    def maximumCount(self, nums):
        n = len(nums)
        neg = 0
        p = 0
        negl = 0
        posf = 0
        posl = 0

        if nums[0] == 0 and nums[n - 1] == 0:
            return 0

        i, j = 0, n - 1
        while i <= j:
            mid = i + (j - i) // 2
            if nums[mid] < 0:
                negl = mid
                i = mid + 1
            else:
                j = mid - 1

        i, j = 0, n - 1
        while i <= j:
            mid = i + (j - i) // 2
            if nums[mid] > 0:
                posf = mid
                j = mid - 1
            else:
                i = mid + 1

        if nums[n - 1] > 0:
            posl = n - 1

        p = posl - posf + 1
        neg = negl - 0 + 1

        return max(p, neg)