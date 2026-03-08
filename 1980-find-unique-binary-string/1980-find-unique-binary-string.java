class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        StringBuilder sb = new StringBuilder();
        recursion(set,0,sb,nums.length);
        return ans;
    }

    public boolean recursion(HashSet<String> set,int i,StringBuilder sb,int n){
        if(i==n){
            if(!set.contains(sb.toString())){
                ans = sb.toString();
                return true;
            } 
            return false;
        }
        sb.append('0');
        boolean isanswer = recursion(set,i+1,sb,n);
        sb.deleteCharAt(sb.length()-1);
        if(isanswer) return true;
        sb.append('1');
        recursion(set,i+1,sb,n);
        sb.deleteCharAt(sb.length()-1);
        if(isanswer) return true;
        return false;
    }
}