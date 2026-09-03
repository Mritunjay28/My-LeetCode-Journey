class Solution {
    public boolean uniformArray(int[] nums1) {
        List<int[]> arr = new ArrayList<>();
         for(int i=0;i<nums1.length;i++){
            
                arr.add(new int[] {nums1[i],i});
            
        }

        Collections.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> odd = new ArrayList<>();
        List<int[]> even = new ArrayList<>();

        for(int i=0;i<arr.size();i++){
            int[] temp =arr.get(i);
            if(temp[0]%2==0) {
                even.add(new int[] {temp[0],temp[1]});
            }
            else{
               odd.add(new int[] {temp[0],temp[1]});
            }
        }

        if(even.size() == nums1.length || odd.size() == nums1.length) return true;

        // all even 
        boolean ispossible=true;
         for(int i=0;i<arr.size();i++){
            int[] val =arr.get(i);
             if(val[0]%2!=0){
                for(int[] temp : odd){
                    if(temp[0] > val[0]) {
                        ispossible =false;
                        break;
                    }
                    if(temp[1]!=val[1] && (val[0]-temp[0] >=1) && ( val[0]-temp[0])%2==0 ) {
                        ispossible =true;
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
             int[] val =arr.get(i);
             if(val[0]%2==0){
                for(int[] temp : odd){
                    if(temp[0] > val[0]) {
                        ispossible =false;
                        break;
                    }
                    if(temp[1]!=val[1] && (val[0]-temp[0] >=1) && ( val[0]-temp[0])%2!=0 ) {
                        ispossible =true;
                        break;
                    }
                    else ispossible=false;
                }
                  if(!ispossible) break;
            }
        }

        return ispossible;
        
    }
}