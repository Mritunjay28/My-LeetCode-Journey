class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        int[] arr = new int[n+1];
        boolean[] notjudge = new boolean[n+1];
        for(int i=0;i<trust.length;i++){
            int a = trust[i][0] ;
            int b = trust[i][1] ;
            notjudge[a]=true;
            arr[b]++;
        }

        int count=0;
        int label=-1;
        for(int i=0;i<n+1;i++){
            if(arr[i]==n-1 && !notjudge[i]){
                count++;
                label=i;
            } 
        }

        if(count==1) return label;

        return -1;
    }
}