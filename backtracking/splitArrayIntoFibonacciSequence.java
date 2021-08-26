class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        sol(num, list, 0);
        return list;
    }
    
    public boolean sol(String s, List<Integer> list, int idx){
        if(s.length()==idx){
            return list.size()>2;
        }
        int num =0;
        
        for(int i=idx; i<s.length(); i++){
            num = num*10 + (s.charAt(i)-'0');
            if(num<0) return false;
            if(list.size()<2 || list.get(list.size()-1)+list.get(list.size()-2) == num){
                list.add(num);
                if(sol(s, list, i+1)) return true;
                list.remove(list.size()-1);
            }
            if(i==idx && s.charAt(i)=='0')
                return false;
        }
        return false;
    }
}