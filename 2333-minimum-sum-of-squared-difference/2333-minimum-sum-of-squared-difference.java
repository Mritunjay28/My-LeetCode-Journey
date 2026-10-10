class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[100001];
        long total=0;
        for(int i=0;i<n;i++){
            diff[Math.abs(nums1[i]-nums2[i])]++;
            total+= Math.abs(nums1[i]-nums2[i]);
        } 

        long k= k1+k2;
        if(total<=k) return 0;
        
        for(int i=diff.length-1;i>0;i--){
            if(k >= diff[i]){
                diff[i-1]+=diff[i];
                k-=diff[i];
                diff[i]=0;
            }
            else if (k!=0){
                diff[i-1]+=k;
                diff[i]-=k;
                k=0;
            }

            if(k==0) break;
        }

        long sum=0;
        for(int i=1;i<=diff.length-1;i++) sum += (Math.pow(i,2) * diff[i]);
        return sum;
    }
}