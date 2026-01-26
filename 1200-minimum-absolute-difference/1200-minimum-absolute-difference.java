class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n= arr.length;
        for(int i=1;i<n;i++) min=Math.min(min,arr[i]-arr[i-1]);

        int j=0;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]==min) {
                ans.add(new ArrayList<>());
                ans.get(j).add(arr[i-1]);
                ans.get(j).add(arr[i]);
                j++;
            }
        }

        return ans;
    }
}