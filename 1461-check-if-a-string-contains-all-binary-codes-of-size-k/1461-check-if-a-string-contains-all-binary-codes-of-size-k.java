class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n =s.length();
        HashSet<String> set = new HashSet<>();
    
        int st = 0,e=0;
        StringBuilder sb = new StringBuilder();
        while(e<n){
            sb.append(s.charAt(e));
            while(e-st+1>k) {
                sb.deleteCharAt(0);
                st++;
            }
            if(e-st+1==k) set.add(sb.toString());
            e++;
        }

        int no = (int)Math.pow(2,k);
        return no==set.size();
    }
}