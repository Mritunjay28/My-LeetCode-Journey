class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1) return true;
        int i=1;
        while(i<s.length() && s.charAt(i)=='1') i++;

        if(i==s.length()) return true;

        for(;i<s.length();i++) if(s.charAt(i)=='1') return false;
        return true;
    }
}