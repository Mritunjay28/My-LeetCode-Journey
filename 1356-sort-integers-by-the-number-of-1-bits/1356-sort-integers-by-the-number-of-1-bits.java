class Solution {
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(int i=0;i<arr.length;i++) {
            int bits = Integer.bitCount(arr[i]);
            if(!map.containsKey(bits)) map.put(bits,new ArrayList<>());
            map.get(bits).add(arr[i]);
        }
        int j=0;

        for(int k : map.keySet()){
           Collections.sort(map.get(k));
        }

        for(int k : map.keySet()){
            for(int i=0;i<map.get(k).size();i++){
                arr[j++]=map.get(k).get(i);
            }
        }

        return arr;
    }
}