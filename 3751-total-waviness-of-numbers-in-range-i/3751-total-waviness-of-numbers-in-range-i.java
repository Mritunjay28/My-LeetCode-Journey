class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=Math.max(100,num1);i<=num2;i++){
            String s = Integer.toString(i);
            int digits = s.length();
            for(int j=1;j<digits-1;j++) {
                if(s.charAt(j)<s.charAt(j-1) && s.charAt(j)<s.charAt(j+1)) count++;
                if(s.charAt(j)>s.charAt(j-1) && s.charAt(j)>s.charAt(j+1)) count++;
            }
        }

        return count;
    }
}