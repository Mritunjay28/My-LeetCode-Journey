class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int prev = -1;
        int[] freq = new int[11];
        for (int i = 0; i < reservedSeats.length; i++) {
            int r = reservedSeats[i][0];
            int c = reservedSeats[i][1];

            if (prev == -1) {
                if(r!=1){
                   count += (2* (r-1)); 
                }
                prev = r;
                freq[c]++;
            } else if (r == prev) {
                freq[c]++;
            } else {
                boolean t2345 = false;
                boolean t4567 = false;
                boolean t6789 = false;
                if (freq[2] == 0 && freq[3] == 0 && freq[4] == 0 && freq[5] == 0) {
                    t2345 = true;
                    count++;
                } 
                 if (!t2345 && freq[4] == 0 && freq[5] == 0 && freq[6] == 0 && freq[7] == 0) {
                    t4567 = true;
                    count++;
                }  
                if (!t4567 && freq[6] == 0 && freq[7] == 0 && freq[8] == 0 && freq[9] == 0) {
                    t6789 = true;
                    count++;
                }

                if(prev+1!=r){
                    count += (2* (r-prev-1));
                }
                prev = r;
                freq = new int[11];
                freq[c]++;
            }
        }

        boolean t2345 = false;
        boolean t4567 = false;
        boolean t6789 = false;
        if (freq[2] == 0 && freq[3] == 0 && freq[4] == 0 && freq[5] == 0) {
            t2345 = true;
            count++;
        } 
         if (!t2345 && freq[4] == 0 && freq[5] == 0 && freq[6] == 0 && freq[7] == 0) {
            t4567 = true; 
            count++;
        } 
         if (!t4567 && freq[6] == 0 && freq[7] == 0 && freq[8] == 0 && freq[9] == 0) {
            t6789 = true;
            count++;
        }


        if(prev==-1) return n*2;
        
        return ((n-prev)*2)+count;
    }
}