class Solution {
    public int numberOfSubstrings(String s) {
        int st=0,e=0;
        int n = s.length();
        int a=0,b=0,c=0;
        int ans=0;
        while(e<n){
            if(s.charAt(e)=='a') a++;
            else if(s.charAt(e)=='b') b++;
            else c++;

            while(a>=1 && b>=1 && c>=1){
                ans+= 1+ (n-1-e);
                if(s.charAt(st)=='a') a--;
                else if(s.charAt(st)=='b') b--;
                else c--;
                st++;
            }

            e++;
        }

        return ans;
    }
}