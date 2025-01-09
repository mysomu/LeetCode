class Solution {
    public int maxScore(String s) {
        int ones = 0, zeros = 0, maxScore = 0;
        for(char c : s.toCharArray()){
            if(c=='1') ones++;
        }
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='0') zeros++;
            else ones--;
            maxScore = Math.max(maxScore, zeros+ones);
        }
        return  maxScore;
    }
}