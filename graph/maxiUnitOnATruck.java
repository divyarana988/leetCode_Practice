class Solution {
    public int maximumUnits(int[][] boxes, int truckSize) {
        int n = boxes.length;
        Arrays.sort(boxes, (int[]a, int[]b)->{
            return b[1] - a[1];
        });
        int ans = 0;
        for(int i=0; i<boxes.length; i++){
            int minB = Math.min(boxes[i][0], truckSize);
            truckSize -= minB;
            ans += minB * boxes[i][1];
            
            if(truckSize == 0)
                break;
        }
        return ans;
    }
}