class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[]check = new char[]{'(', ')'};
        dfs(s, res, check, 0, 0);
        return res;
    }
    
    public static void dfs(String s, List<String> res, char[]check, int last_i, int last_j){
        int count = 0;
        int i = last_i;
        
        while(i<s.length() && count>=0){
            if(s.charAt(i) == check[0])
                count++;
            if(s.charAt(i) == check[1])
                count--;
            i++;
        }
        
        if(count>=0){
            String reversed = new StringBuilder(s).reverse().toString();
            if(check[0] == '(')
                dfs(reversed, res, new char[]{')', '('}, 0, 0);
            else
                res.add(reversed);
                
        }else{
            i-=1;
            
            for(int j= last_j; j<=i; j++){
                if(s.charAt(j)==check[1] && (j==last_j || s.charAt(j-1)!=check[1]))
                    dfs(s.substring(0, j)+s.substring(j+1, s.length()), res, check, i, j);
            }
        }
    }
}