class Solution {
    public int numberOfBeams(String[] bank) {
        int count=0;
        int prev = 0;
        boolean prevrow = true;
        int m= bank.length;

        for(int i=0;i<m;i++){
            int curr=0;
            for(int j=0;j<bank[i].length();j++){
                  if(bank[i].charAt(j)=='1'){
                    curr++;
                } 
            }
            
            if(curr>0) {
                count+=prev*curr;
                prev=curr;
            }
          
        }

    return count;
}
}