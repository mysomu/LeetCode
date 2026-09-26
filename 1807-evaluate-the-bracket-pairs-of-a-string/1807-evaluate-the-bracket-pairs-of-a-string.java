class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> h= new HashMap<>();
         for (List<String> l:knowledge) {
            h.put(l.get(0),l.get(1));
        }
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                i++;
                String r="";
                while(s.charAt(i)!=')' && i<s.length()){
                    r+=s.charAt(i);
                    i++;
                }
                //System.out.println(r);
                if(h.containsKey(r)){
                    ans+=h.get(r);
                }
                else
                    ans+="?";
            }
            else
                ans+=ch;
        }
        return ans;
    }
}