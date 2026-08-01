class Solution {
    public boolean predictTheWinner(int[] nums) {
        return f(0,0,0,nums.length-1,nums,true);
    }

    public boolean f(int sum1,int sum2,int i,int j,int[]nums,boolean first){
        if(i>j){
            if(sum1>=sum2) return true;
            return false;
        } 

      
        // can take back or first one 
        // first 
        if(first) {
            boolean pickleft = f(sum1+nums[i],sum2,i+1,j,nums,!first);
            boolean pickright = f(sum1+nums[j],sum2,i,j-1,nums,!first);
            return pickleft || pickright;
        }
        else{
            boolean pickleft = f(sum1,sum2+nums[i],i+1,j,nums,!first);
            boolean pickright = f(sum1,sum2+nums[j],i,j-1,nums,!first);
            return pickleft &&   pickright;
        }
    }
}