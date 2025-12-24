class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int n=apple.length , m =capacity.length;
        int j=m-1,i=0;
        while(i<n){
            if(apple[i]<=capacity[j]){
                capacity[j]-=apple[i];
                 i++;
            } 
            else{
                apple[i]-=capacity[j];
                if(apple[i]!=0) j--;
            }
        }

        return m-j;
    }
}