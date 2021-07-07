class Solution {
    public int maxDepth(String s) {
        
        int max = 0;
        int curr = 0;
        
        for(char ch: s.toCharArray()){
            
            if(ch=='('){
                ++curr;
            }
            if(ch==')'){
                if(max<curr){
                    max = curr;
                }
                --curr;
            }            
        }
        return max;
        
    }
}

