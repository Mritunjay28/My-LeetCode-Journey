class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        int m = strs.length , n =strs[0].length();
        HashMap<Integer,StringBuilder> map = new HashMap<>();

       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!map.containsKey(j)) map.put(j,new StringBuilder());
            map.get(j).append(strs[i].charAt(j));
        }
       }


       for(Map.Entry<Integer,StringBuilder> entry : map.entrySet()){
        StringBuilder value = entry.getValue();
        char[] arr = value.toString().toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        if(!value.toString().equals(sorted)) count++;
       }

       return count;
    }
}