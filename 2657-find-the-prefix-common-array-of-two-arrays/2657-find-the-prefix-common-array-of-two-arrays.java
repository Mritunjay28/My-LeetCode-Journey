class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr=new int[51];
        int[] ans=new int[A.length];
        int count=0;
        for(int i=0;i<A.length;i++){
            arr[A[i]]++;
            if(arr[A[i]]%2==0) count++;
            arr[B[i]]++;
            if(arr[B[i]]%2==0) count++;

            ans[i]=count;

        }

        return ans;
        
    }
}