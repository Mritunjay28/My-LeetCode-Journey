class Solution {
    public int minNumberOperations(int[] target) {
        // Stack<Integer> stack = new Stack<>();
        int prev=target[0];
        int sum=0;
        for(int i=1;i<target.length;i++){
            if(target[i] >= prev){
                prev= target[i];
            }
            else{
                sum+= prev - target[i];
                prev = target[i];
            }
        }
        sum+= target[target.length-1];

        return sum;
    }
}