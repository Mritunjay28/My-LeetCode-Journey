class Solution {
    public boolean scoreBalance(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum+= (int)(s.charAt(i)-'a')+1;
        }

        int currsum=0;
        for(int i=0;i<s.length();i++){
            currsum+= (int)(s.charAt(i)-'a')+1;
            if(currsum== sum-currsum) return true;
        }
        return false;
    }
}