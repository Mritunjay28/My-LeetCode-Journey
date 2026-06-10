class Solution {
    int[] tree ;
    int n;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        int count=0;
        tree = new int[4*n];

        buildSeg(0,0,n-1,baskets);

        for(int i=0;i<fruits.length;i++){
            int idx = bs(0,0,n-1,fruits[i]);
           
            if(idx==-1) count++;
            else update(idx,-1,0,0,n-1);

        }

        return count;
    }

    public int bs(int i,int l,int r,int fruit){

        if(tree[i] <fruit) return -1;

        if(l==r) return l;

         int mid = l + (r - l) / 2;

        if (tree[2*i + 1] >= fruit)
            return bs(2 * i + 1, l, mid, fruit);

        return bs(2 * i + 2, mid + 1, r, fruit);
    }

    

    public void update(int idx , int val,int i,int l,int r){
        if(l==r){
            tree[i]=val;
            return;
        }

        int mid = l+(r-l)/2;
        if(idx<=mid) update(idx,val,2*i+1,l,mid);
        else  update(idx,val,2*i+2,mid+1,r);

        tree[i]= Math.max(tree[2*i+1] , tree[2*i+2]);
        
    }

    public void buildSeg(int i,int l,int r,int[] num){
        if(l==r){
            tree[i] = num[l];
            return;
        }

        int mid = l+(r-l)/2;

        buildSeg(2*i+1,l,mid,num);
        buildSeg(2*i+2,mid+1,r,num);

        tree[i]= Math.max(tree[2*i+1] , tree[2*i+2]);

    }
}
