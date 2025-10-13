class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev="";

        for(int i=0;i<words.length;i++){
            String curr = words[i];
            char[] arr = curr.toCharArray();
            Arrays.sort(arr);
            String sorted =String.valueOf(arr);
            if(!sorted.equals(prev)){
                ans.add(curr);
                prev=sorted;
            }
        }
        return ans;
    }
}