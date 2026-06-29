class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count =0;
        for(String str: patterns){
            if(word.contains(str)){
                count++;
            }
        }
        return count;
    }
}