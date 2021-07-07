class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int s1=0, s2=0;
        int n = Math.max(word1.length(), word2.length());
        
        
        while(s1<word1.length() || s2<word2.length()){
            
            if(s1<word1.length()){
                sb.append(word1.charAt(s1++));
            }
            
            if(s2<word2.length()){
                sb.append(word2.charAt(s2++));
            }
            
        }
        return sb.toString();
    }
}