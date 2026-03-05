class Solution {
    public int minOperations(String s) {
        int count=0;
        // either 010101 || 10101010
        // check in 2 
        int not0=0,not1=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)!='0') not0++;
            if(i%2!=0 && s.charAt(i)!='1') not1++;
        }

        count=not0+not1;

        not0=0;
        not1=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)!='1') not1++;
            if(i%2!=0 && s.charAt(i)!='0') not0++;
        }

        count=Math.min(count,not0+not1);
        return count;
    }
}