class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<command.length(); i++){
            
            char ch = command.charAt(i);
            
            if(ch=='G'){
                sb.append(ch);
            }
            else if(ch=='('){
                if(command.charAt(i+1)==')'){
                    sb.append('o');
                    i++;
                }   
                else{
                    sb.append("al");
                }
            }
        }
        return sb.toString();
    }
}