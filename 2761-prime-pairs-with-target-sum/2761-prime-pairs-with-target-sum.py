class Solution:
    def findPrimePairs(self, n: int) -> List[List[int]]:
        res = []
        prime = [True]*(n+1)
        for i in range(2,int(n**0.5)+1):
            if prime[i]==True:
                for j in range(i*i,n+1,i):    
                    prime[j]=False

        for  p in range(2,n//2+1):
            if prime[p] and prime[n-p]:
                res.append([p,n-p])

        return res
        