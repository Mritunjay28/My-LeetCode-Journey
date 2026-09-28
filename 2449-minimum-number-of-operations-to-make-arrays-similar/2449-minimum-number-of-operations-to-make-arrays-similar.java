class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long count = 0;

        List<Integer> even = new ArrayList<>();
        List<Integer> eventarget = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> oddtarget = new ArrayList<>();

        Arrays.sort(nums);
        Arrays.sort(target);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);

            if(target[i] % 2 == 0) eventarget.add(target[i]);
            else oddtarget.add(target[i]);
        }

        for(int i = 0; i < even.size(); i++) {
            if(even.get(i) > eventarget.get(i)) count += even.get(i) - eventarget.get(i);
        }

        for(int i = 0; i < odd.size(); i++) {
            if(odd.get(i) > oddtarget.get(i)) count += odd.get(i) - oddtarget.get(i);
        }

        return count / 2;

    }
}