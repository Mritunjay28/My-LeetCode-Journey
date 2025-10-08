class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m= potions.length;

        Arrays.sort(potions);

        int[] ans = new int[n];
        int i=0;
        while(i<n){
            ans[i]=binarysearch(0,m-1,potions,spells[i],success);
            i++;
        }
        return ans;
    }

    private int binarysearch(int s,int e,int[] arr,int num,long target){
        int ans=-1;
        int end= e;
        while(s<=e){
            int mid = s+(e-s)/2;
            if((long)num*arr[mid]>=target){
                ans=mid;
                e=mid-1;
            }
            else s=mid+1;
        }

        return (ans==-1) ? 0: end-ans+1;  
    }

}

/*
    basically given 2 array want to find for each no of product for which product value  > success and return an arrray for each value in spells 

    if we see this as if we sort both nlogn + mlogm do binary search for all n elemnt will get result in logn 

    t.c =  mlogm + n*logm  = (m+n)logm


    thinking of applying binary search as if sorted then we just have to find starting potion position which allow us to make succes then all next will be done 
*/ 