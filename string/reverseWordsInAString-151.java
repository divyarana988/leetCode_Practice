class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(int i = words.length-1; i>=0;i--){
             if(!words[i].trim().isEmpty()){
                 sb.append(words[i]+" ");
               }
         }
         return sb.toString().trim();
     }
}