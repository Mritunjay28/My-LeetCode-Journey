class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int total = nums.length;
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            map.putIfAbsent(val, new TreeSet<>());
            map.get(val).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            int val = nums[idx];

            // find idx location list of values 
            if (!map.containsKey(val) || map.get(val).size() < 2)
                ans.add(-1);
            else {
                TreeSet<Integer> set = map.get(val);
                Integer left = set.lower(idx);
                Integer right = set.higher(idx);

                int min = Integer.MAX_VALUE;

                if (right != null) min = Math.min(min, right - idx);
                else  min = Math.min(min, total - idx + set.first());
                

                if (left != null)  min = Math.min(min, idx - left);
                else  min = Math.min(min, idx + (total - set.last()));

                ans.add(min);
            }
        }

        return ans;
    }
}