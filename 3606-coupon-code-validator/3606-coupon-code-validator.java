class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String,Integer> businessorder =new HashMap<>();
        businessorder.put("electronics",0);
        businessorder.put("grocery",1);
        businessorder.put("pharmacy",2);
        businessorder.put("restaurant",3);

        List<String[]> valid = new ArrayList<>();
        for(int i=0 ; i<code.length;i++){
            String c = code[i];
            String b = businessLine[i];
            boolean active = isActive[i];

            if(!c.isEmpty() && c.matches("[a-zA-Z0-9_]+") && businessorder.containsKey(b) && active){
                valid.add(new String[]{c,b});
            }
        }

        valid.sort((a,b) -> {
           int compare = Integer.compare(businessorder.get(a[1]),businessorder.get(b[1])) ;
            if(compare!=0) return compare;
            return a[0].compareTo(b[0]);
        });

        List<String> ans = new ArrayList<>();
        for(String[] arr :valid ) ans.add(arr[0]);

        return ans;
    }
}