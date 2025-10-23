class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            int n= s.length();
            StringBuilder str = new StringBuilder();
            for(int i=0;i<n-1;i++){
                str.append((char)((((int)(s.charAt(i)-'0')+(int)(s.charAt(i+1)-'0'))% 10) + '0'));
            }
            s= str.toString();
            System.out.println(s);
        }

        if(s.charAt(0)==s.charAt(1)) return true;
        return false;
    }
}