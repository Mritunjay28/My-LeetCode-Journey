class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
      TreeMap<Integer,Integer> map = new TreeMap<>();

        
        for(int i=0;i<flowers.length;i++){
            map.put(flowers[i][0],map.getOrDefault(flowers[i][0],0)+1);
            map.put(flowers[i][1]+1,map.getOrDefault(flowers[i][1]+1,0)-1);
        }
        
        int running = 0;
        for (int key : map.keySet()) {
            running += map.get(key);
            map.put(key, running);
        }

        int[] ans = new int[people.length];

       
        for (int i = 0; i < people.length; i++) {
            Integer key = map.floorKey(people[i]);
            ans[i] = (key == null) ? 0 : map.get(key);
        }

        return ans;
    }
}