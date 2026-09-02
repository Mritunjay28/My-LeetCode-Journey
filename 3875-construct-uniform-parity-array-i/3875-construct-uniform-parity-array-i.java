class Solution {
    public boolean uniformArray(int[] nums1) {
        List<int[]> odd = new ArrayList<>();
        List<int[]> even = new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0) {
                even.add(new int[] {nums1[i],i});
            }
            else{
                odd.add(new int[] {nums1[i],i});
            }
        }

        // all even 
        boolean ispossible=true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2!=0){
                for(int[] temp : odd){
                    if(temp[1]!=i && (nums1[i]-temp[0])%2==0) {
                         ispossible=true;
                        break;
                    }
                    else ispossible=false;
                }
                 if(!ispossible) break;
            }
        }

        if(ispossible) return true;

        // all odd 
        ispossible=true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                for(int[] temp : odd){
                    if(temp[1]!=i && (nums1[i]-temp[0])%2!=0) {
                         ispossible=true;
                        break;
                    }
                    else ispossible=false;
                }
                if(!ispossible) return false;
            }
        }

        return ispossible;
        
    }
}