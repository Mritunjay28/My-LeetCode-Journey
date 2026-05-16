class Solution {
    public int findMin(int[] nums) {
        int s=0,e=nums.length-1;

        while(s<e){
            int mid = s+(e-s)/2;

            if(nums[mid]>nums[e]) {
                s=mid+1;
            }
            else {
                e=mid;
            }

        }

        return nums[s];
    }
}
/*

we have s,e m

3 cases 

// ascending 
check if mid creater then s,e if from any one then make that =mid 

// descending - same 

// now rotated 
in rotated min always lie btw   _ _ max min _ _ _  
so use above strategy but condisitio that it is _> min <_ 

*/