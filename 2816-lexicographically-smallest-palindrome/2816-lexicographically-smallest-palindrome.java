class Solution {
    public String makeSmallestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char ch[] = s.toCharArray();
        while(i<j){
           if(ch[i]!=ch[j]){
            ch[i]=ch[j]=(char) Math.min(ch[i], ch[j]);
            }
            i++;
            j--;
        }
        return new String(ch);        
    }
}