class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0;
        int count=0;
        int ans =0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(map.get(s.charAt(r))>1) count++;

            while(count>0){
                if(map.get(s.charAt(l)) >1) count--;
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                l++;
            } 
            ans =Math.max(ans,r-l+1);
            r++;
        }

        return ans;
    }
}