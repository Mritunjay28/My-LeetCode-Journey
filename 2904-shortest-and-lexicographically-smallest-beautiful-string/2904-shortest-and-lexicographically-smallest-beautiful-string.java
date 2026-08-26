class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int min = Integer.MAX_VALUE;
        List<String> set = new ArrayList<>();
        int l =0,r=0;
        while(r<s.length()){
            if(s.charAt(r)=='1') k--; 

            while(k<0){
                if(s.charAt(l)=='1') k++;
                l++;
                while(s.charAt(l)=='0') l++;
            }

            if(k==0){
                while(s.charAt(l)=='0') l++;
                int len = r-l+1;
                if(len<min) {
                    min=len;
                    set = new ArrayList<>();
                    set.add(s.substring(l,r+1));
                }
                else if(len==min) set.add(s.substring(l,r+1));
            }
            r++;
        }

        if(min==Integer.MAX_VALUE) return "";

        while(s.charAt(l)=='0') l++;
        int len = r-l;
                if(len<min) {
                    min=len;
                    set = new ArrayList<>();
                    set.add(s.substring(l,r));
                }
                else if(len==min) set.add(s.substring(l,r));
        
        Collections.sort(set);

        return set.get(0);
    }
}