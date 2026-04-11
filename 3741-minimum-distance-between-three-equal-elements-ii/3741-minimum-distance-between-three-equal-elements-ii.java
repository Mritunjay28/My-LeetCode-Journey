class Solution {
    public int minimumDistance(int[] nums) {
        int n= nums.length;
        if(n<=2) return -1;
        int min =10000000;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            if(list.size() >=3){
                for(int i=0;i+2<list.size();i++){
                   int a = list.get(i);
                    int c = list.get(i+2);
                    int dist = 2* (c-a);
                    min=Math.min(min,dist);      
                }
            }
        }

        if(min==10000000) return -1;
        return min;
        
    }
}