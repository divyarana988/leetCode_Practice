class Solution {
 public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        backtrack(s,list,new StringBuilder(),0,0);
        return list;
    }
    private void backtrack(String s, List<String> list, StringBuilder sb, int index, int level){
        if(index > s.length() || level > 4) return;
        else if(index == s.length() && level == 4){
            list.add(sb.toString());
            return;
        }
        int siz = sb.length();
        for(int i = 1;i <= 3;i++){
            if(index+i > s.length()) break;
            int num = Integer.valueOf(s.substring(index,index+i));
            //Checking if num is 0~9 or 10~99 or 100 ~ 255 because leading 0s is invalid.
            if(num>=256) break;
           
                sb.append(num);
                if(level < 3) sb.append(".");
                backtrack(s,list,sb,index+i,level+1);
                sb.setLength(siz);
            
            if(num == 0) break;
        }
    }
}
