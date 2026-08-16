class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // List<Integer> ans = new ArrayList<>();
        
        // for (int i = 0; i < nums.length; i++) {
        //     List<Integer> curr = f(i, nums);
        //     if (ans.size() < curr.size()) {
        //         ans = curr;
        //     }
        // }

        // return ans;

        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            result.add(nums[curr]);
            curr = parent[curr];
        }

        return result;
    }

    public List<Integer> f(int i, int[] nums) {

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[i]);
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % nums[i] == 0) {
                List<Integer> curr = f(j, nums);
                if (curr.size() + 1 > ans.size()) {
                    curr.add(nums[i]);
                    ans = curr;
                }
            }
        }

        return ans;
    }
}