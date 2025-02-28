class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtraking(n,res,s,openc,closec):
            if len(s) == n*2:
                res.append(s)
            if openc <n:
                backtraking(n,res,s+'(',openc+1,closec)
            if closec<n and closec<openc:
                backtraking(n,res,s+')',openc,closec+1)



        res = []
        backtraking(n,res,'',0,0)
        return res
    
