class Solution {
    public int totalNumbers(int[] digits) {
        Set<String> numberSet = new HashSet<>();
        StringBuilder number = new StringBuilder();
        buildNumber(digits,number,numberSet);
        return numberSet.size();
    }
    public void buildNumber(int [] digits,StringBuilder number, Set<String> numberSet){
        int idx = number.length();
        if(idx==3){
            numberSet.add(number.toString());
            return;
        }
        for(int i=0; i<digits.length; i++){
            // the used digit was set to -1
            if(digits[i]==-1){
                continue;
            }
            if(idx == 0 && digits[i]==0 || idx == 2 && digits[i]%2==1){
                continue;
            }
            int origDigit = digits[i];
            number.append(digits[i]);
            digits[i] = -1;
            buildNumber(digits,number,numberSet);
            // restore the state for backtracking
            number.setLength(number.length()-1);
            digits[i]=origDigit;
        }
    }

}