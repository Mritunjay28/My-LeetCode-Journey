class Solution {
    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = fun1(nums[i]);
        return ans;
    }
    int fun1(int num) {
        int low = 0;
        for(int i = num; i >= 0; i--) {
            if(fun2(i)) {
                low = num - i;
                break;
            }
        }
        int up = 0;
        int v = num;
        while(true) {
            if(fun2(v)) {
                up = v - num;
                break;
            }
            v++;
        }
        return Math.min(low, up);
    }
    boolean fun2(int num) {
        String s = Integer.toBinaryString(num);
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}