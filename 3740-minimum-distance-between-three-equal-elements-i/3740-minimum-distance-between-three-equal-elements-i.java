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
                for(int i=0;i<list.size();i++){
                    for(int j=i+1;j<list.size();j++){
                        for(int k=j+1;k<list.size();k++){
                            min=Math.min(min,Math.abs(list.get(i)-list.get(j))+Math.abs(list.get(i)-list.get(k))+Math.abs(list.get(k)-list.get(j)));
                        }
                    }
                }
            }
        }

        if(min==10000000) return -1;
        return min;
        
    }
}