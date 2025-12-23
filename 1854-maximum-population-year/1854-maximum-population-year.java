class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        for(int i=0;i<logs.length;i++){
            arr[logs[i][0]-1950]++;
            arr[logs[i][1]-1950]--;
        }

        for(int i=1;i<101;i++) arr[i]+=arr[i-1];

        int max=-1,idx=-1;
        for(int i=0;i<101;i++){
            if(max<arr[i]){
                max=arr[i];
                idx=i;
            }
        }

        return idx+1950;
    }
}