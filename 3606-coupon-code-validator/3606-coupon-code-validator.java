class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> valid= new ArrayList<>();

        HashMap<String,Integer> priority = new HashMap<>();
        priority.put("electronics",0);
        priority.put("grocery",1);
        priority.put("pharmacy",2);
        priority.put("restaurant",3);


        for(int i=0;i<code.length;i++){
            String c = code[i];
            String b= businessLine[i];
            boolean active = isActive[i] ;
            if(c!=null && c.matches("^[A-Za-z0-9_]+$") && priority.containsKey(b) && active) {
                valid.add(new String[]{c,b});
            }
        }

        valid.sort((a,b)->{
            int compare = Integer.compare(priority.get(a[1]),priority.get(b[1]));
            if(compare!=0) return compare;
            return a[0].compareTo(b[0]);
        });

        List<String> ans= new ArrayList<>();
        for(String[] arr : valid) ans.add(arr[0]);
        return ans;
    }
}