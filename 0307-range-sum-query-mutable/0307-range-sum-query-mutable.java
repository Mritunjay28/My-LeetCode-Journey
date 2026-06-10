class NumArray {
    int n;
    int tree[];
    int lazy[];


    public NumArray(int[] nums) {
         n =nums.length;
        tree = new int[4*n];
        lazy = new int[4*n];

        buildSeg(0,0,n-1,nums);
    }

    public void buildSeg(int i,int l,int r, int[] nums){

        if(l==r){
            tree[i] = nums[l];
            return;
        }

        int mid = l+(r-l)/2;

        buildSeg(2*i+1,l,mid,nums);
        buildSeg(2*i+2,mid+1,r,nums);

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }
    
    public void update(int index, int val) {
        updateTree(0,0,n-1,index,val);
    }

    public void updateTree(int i,int l,int r, int index ,int val){

        if(l==r){
            tree[i] = val;
            return;
        }

        int mid = l+(r-l)/2;

        if(index<=mid) updateTree(2*i+1,l,mid,index,val);
        else updateTree(2*i+2,mid+1,r,index,val);

        tree[i]= tree[2*i+1] + tree[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        return sum(left,right,0,0,n-1);
    }

    public int sum(int st,int e, int i,int l,int r){

        if(l>e || st>r) return 0;

        if(l>=st && r<=e) return tree[i];

        int mid = l+(r-l)/2;

        return sum(st,e,2*i+1,l,mid) + sum(st,e,2*i+2,mid+1,r) ;
    }


    public void updateRange(int left,int right,int val){  // update l-r for value val , lazy propagation
        updateRange(0, 0, n - 1, left, right, val);
    }


    public void updateRange(int i,int l,int r,int st, int e,int val){

        push(i,l,r); // take of lazy part

        if(r<st || e<l) return ; // non overlap

        if(st <= l && r<=e) {
            lazy[i] += val;
            push(i,l,r); 

            return;
        }   

        int mid = l + (r - l) / 2;

        updateRange(2 * i + 1,l,mid,st,e,val);
        updateRange(2 * i + 2,mid+1,r,st,e,val);

   
        tree[i] = tree[2*i + 1] + tree[2 * i + 2];
    }

    private void push(int i, int l, int r) {

        if(lazy[i]==0) return;

        tree[i] += (r-l+1) * lazy[i];

        if(l!=r) { // have children
            lazy[2*i+1] += lazy[i];
            lazy[2*i+2] += lazy[i];
        }

        lazy[i] = 0;
    }




}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */