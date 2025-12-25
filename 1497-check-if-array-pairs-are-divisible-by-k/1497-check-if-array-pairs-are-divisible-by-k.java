class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] % k;
            if (val < 0) val += k;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        if (map.getOrDefault(0, 0) % 2 != 0) return false;

        for (int r : map.keySet()) {
            if (r == 0) continue;

            int need = k - r; 
            
           
            if (r == need) {
                if (map.get(r) % 2 != 0) return false;
            } 
           
            else if (!map.get(r).equals(map.getOrDefault(need, 0))) {
                return false;
            }
        }
        return true;
    }
}