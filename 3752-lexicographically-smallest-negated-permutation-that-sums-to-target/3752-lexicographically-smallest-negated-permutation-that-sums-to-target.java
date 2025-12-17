class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
       long s = sum(n);

       if(s<target || target<-s ) return new int[0];

       ArrayList<Integer> arr = new ArrayList<>();
       for(int i=n;i>0;i--){
        if(sum(i-1)-i >=target){
            target+=i;
            arr.add(-i);
        }
        else {
            target-=i;
            arr.add(i);
        }
       }

       if(target!=0) return new int[0];
       arr.sort(null);

        int[] ans =new int[arr.size()];
        for(int i=0;i<arr.size();i++) ans[i]=arr.get(i);

        return ans;
    }

    private long sum(long n){
        return n*(n+1)/2;
    }
}

// condition :
/*
(1+2+3+4+5)-6 >=target add to target 
sumof (i-1) - i >=target add to target mean add(-i)
else add (i) and subtract to target 

check at last if target==0 else return 
 */