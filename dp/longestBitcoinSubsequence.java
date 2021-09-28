public int lbs(int []arr){
    int lis[] = new int[arr.length];
    int lds[] = new int[arr.length];

    for(int i = 0; i<arr.length; i++){
        for(int j=0; j<i; j++){
            int max=0;
            if(arr[j]<arr[i]){
                max = Math.max(max, lis[j]);
            }
        }
        lis[i] = max+1;
    }

    for(int i=arr.length-1; i>=0; i--){
        for(int j=0; j<i; j++){
            int max = 0;
            if(arr[j]<arr[i]){
                max = Math.max(max, lds[j]);
            }
        }
        lds[i] = max+1;
    }
    int oans = 0;
    for(int i=0; i<arr.length; i++){
        int len = lis[i]+lds[i]-1;
        if(oans<len){
            oans = len;
        }
    }
    return oans;
}