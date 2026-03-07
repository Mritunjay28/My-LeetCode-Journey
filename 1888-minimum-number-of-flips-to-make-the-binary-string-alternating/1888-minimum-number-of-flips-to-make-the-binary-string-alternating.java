class Solution {
    public int minFlips(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        int min=Integer.MAX_VALUE;
        int cost0=0,cost1=0;
        for(int i=0;i<sb.length();i++){
           char expect0 = (i%2==0) ? '0' : '1' ;
           char expect1 = (i%2==0) ? '1' : '0' ;

           if(sb.charAt(i) !=expect0) cost0++;
           if(sb.charAt(i) !=expect1) cost1++;

           if(i>=s.length()){
            char prevexpect0 = ((i-s.length())%2==0) ? '0' : '1' ;
           char prevexpect1 = ((i-s.length())%2==0) ? '1' : '0' ;

           if(sb.charAt((i-s.length())) !=prevexpect0) cost0--;
           if(sb.charAt((i-s.length())) !=prevexpect1) cost1--;
           }

           if(i>=s.length()-1) min=Math.min(min,Math.min(cost0,cost1));
        }


        return min;

    }
}
/*
111000111000
*/ 