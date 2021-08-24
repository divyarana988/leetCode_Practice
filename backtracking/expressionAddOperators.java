class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        if(num == null || num.length() == 0) return list;
        StringBuilder sb = new StringBuilder();
        helper(list, sb, num, target, 0, 0, 0);
        return list;
    }
    public void helper(List<String> list, StringBuilder sb, String num, int target, int pos, long eval, long prevN){
        if(pos == num.length()){
            if(target == eval)
                list.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int siz = sb.length();
            if(pos == 0){
                helper(list, sb.append(cur), num, target, i + 1, cur, cur);
                sb.setLength(siz);
            }
            else{
                helper(list, sb.append("+").append(cur), num, target, i + 1, eval + cur , cur);
                sb.setLength(siz);
                helper(list, sb.append("-").append(cur), num, target, i + 1, eval -cur, -cur);
                sb.setLength(siz);
                helper(list, sb.append("*").append(cur), num, target, i + 1, eval - prevN + prevN * cur, prevN * cur );
                sb.setLength(siz);
            }
        }
    }
}


