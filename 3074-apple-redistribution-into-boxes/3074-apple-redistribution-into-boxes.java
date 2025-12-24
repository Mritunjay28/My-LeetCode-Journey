class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int n=apple.length , m =capacity.length;
        int j=m-1,i=0;
        while(i<n){
            if(apple[i]<=capacity[j]){
                capacity[j]-=apple[i];
                apple[i]=0;
            } 
            else{
                apple[i]-=capacity[j];
                if(apple[i]!=0) j--;
            }
            if(apple[i]==0) i++;
        }

        return m-j;
    }
}