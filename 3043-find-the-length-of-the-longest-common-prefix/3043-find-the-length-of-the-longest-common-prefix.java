class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            String s = String.valueOf(arr2[i]);
            for (int j = 1; j <= s.length(); j++) {
                String prefix =s.substring(0, j);
                set.add(prefix);
            }
        }

        int ans=0;

        for (int i = 0; i < arr1.length; i++) {
            String s = String.valueOf(arr1[i]);
            for (int j = 1; j <= s.length(); j++) {
                String prefix = s.substring(0, j);
                if(set.contains(prefix)) {
                    ans=Math.max(ans,prefix.length());
                }
                else break;
            }
        }

        return ans;
    }
}