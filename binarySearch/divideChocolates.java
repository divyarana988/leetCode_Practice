public int maximizeSweetness(int[] arr, int k) {
        int low = 1;
        int high = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            high+=arr[i];
        }
        int ans = 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sol(arr, n, mid, k)==true){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean sol(int arr[], int n, int maxi, int k){
        int part = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum>=maxi){
                part++;
                sum=0;
            }
        }
        return part>=k+1;
    }