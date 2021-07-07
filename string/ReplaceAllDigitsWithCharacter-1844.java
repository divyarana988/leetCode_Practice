class Solution {
    public String replaceDigits(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length()-1; i+=2){            
            sb.append(s.charAt(i)).append((char)(s.charAt(i) + s.charAt(i+1) - '0'));
         }
        
        if(s.length() % 2 == 1){
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }
}


