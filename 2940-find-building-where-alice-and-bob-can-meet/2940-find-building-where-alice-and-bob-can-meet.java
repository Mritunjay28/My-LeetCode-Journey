class Solution {
    int[] tree ;
    int n;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        int m = queries.length ; 
        int[] ans = new int[m];
        tree = new int[4*n];

        buildSeg(0,0,n-1,heights);

        for(int i=0;i<m;i++){
            int a = queries[i][0] ;
            int b = queries[i][1];

            if(a==b) ans[i]=a;
            else if ( a < b && heights[a] < heights[b]) ans[i]=b;
            else if ( b < a && heights[b] < heights[a]) ans[i]=a;
            else{
                int max = Math.max(a,b);

            ans[i] = bs(max+1,n-1,a,b,heights);
            }
        }

        return ans;
    }

    public int bs(int l,int r,int a ,int b,int[] nums){
        int ans =-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            int max = check(l,mid,0,0,n-1, nums);

            if(max!=-1 && nums[max]>nums[a] && nums[max]>nums[b]){
                ans=mid;
                r=mid-1;
            }
            else l= mid+1;
        }

        return ans;
    }

    public int check(int st,int e,int i,int l ,int r,int[] nums){


        if(r<st || l>e) return -1;

        if(l>=st && r<=e) return tree[i];

        int mid = l+(r-l)/2;

        int leftidx = check(st,e,2*i+1,l,mid,nums);
        int rightidx = check(st,e,2*i+2,mid+1,r,nums);

        if(leftidx==-1 && rightidx==-1) return -1;
        if(leftidx==-1) return rightidx;
        if(rightidx==-1) return leftidx;

        if(nums[leftidx] >= nums[rightidx]) return leftidx;
        return rightidx;

    }

    public void buildSeg(int i,int l,int r,int[] num){
        if(l==r){
            tree[i] = l;
            return;
        }

        int mid = l+(r-l)/2;

        buildSeg(2*i+1,l,mid,num);
        buildSeg(2*i+2,mid+1,r,num);

        int leftidx = tree[2*i+1];
        int rightidx = tree[2*i+2];

        if(num[leftidx] >= num[rightidx]) tree[i]=leftidx;
        else tree[i] = rightidx;
    }
}