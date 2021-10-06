class Solution {
    public int numSimilarGroups(String[] A) {
        int len = A.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSimilar(A[i],A[j])) uf.union(i,j);
            }
        }
        return uf.size();
    }
    
    public boolean isSimilar(String s, String t) {
        int res = 0, i = 0;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res <= 2;
    }
}

class UnionFind {
    int[] p, rank;
    int num;
    public UnionFind(int num){
        p = new int[num];
        rank = new int[num];
        for (int i = 0; i < num; i++) {
            p[i] = i;
        }
        this.num = num;
        
    }
    public int find(int index){
        if (p[index] == index) return index;
        
        return p[index] = find(p[index]);
    }
    public void union(int i, int j) {
        int r1 = find(i);
            int r2 = find(j);
            int rank1 = rank[r1];
            int rank2 = rank[r2];
            if(r1==r2){
                return;
            }
            if(rank1>rank2){
                p[r2] = p[r1];
            }
            else if(rank1<rank2){
                p[r1] = r2;
            }
            else{
                p[r2] = r1;
                rank[rank1]++;
            }    
            num--;
    }
    public int size(){
        return num;
    }
}