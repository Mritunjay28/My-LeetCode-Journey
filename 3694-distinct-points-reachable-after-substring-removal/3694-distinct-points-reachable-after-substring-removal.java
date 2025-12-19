class Solution {
    public int distinctPoints(String s, int k) {
        int n= s.length();
        int[] px = new int[n+1];
        int[] py = new int[n+1];
        for(int i=0;i<n;i++){
            px[i+1] +=px[i];
            py[i+1] +=py[i];

            if(s.charAt(i)=='L') px[i+1]--;
            else if(s.charAt(i)=='R') px[i+1]++;
            else if(s.charAt(i)=='U') py[i+1]++;
            else  py[i+1]--;
        }

        int totalx =px[n];
        int totaly =py[n];

        HashSet<Long> seen = new HashSet<>();
        for(int i=0;i+k<=n;i++){
            int removex =px[i+k] - px[i];
            int removey =py[i+k] - py[i];

            int fx = totalx-removex;
            int fy = totaly-removey;

            long key = fx*1000000+fy;
            seen.add(key);
        }

        return seen.size();

    }
}