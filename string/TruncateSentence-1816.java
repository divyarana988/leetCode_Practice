class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb =  new StringBuilder();
        
        for(int i=0 ; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' '){
                k--;
                if(k<=0){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}