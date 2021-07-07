class Solution {
    public String restoreString(String s, int[] indices) {
        char[] nStr = new char[indices.length];
        
        for(int i=0; i<indices.length; i++){
            
            nStr[indices[i]] = s.charAt(i);
            
        }
        
        return new String(nStr);
    }
}