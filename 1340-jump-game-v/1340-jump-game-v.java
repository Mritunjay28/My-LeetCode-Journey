class Solution {
    int max = 0;
    int[][] memo = new int[1001][1001];

    public int maxJumps(int[] arr, int d) {
        // int prefix 
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] prefix = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                prefix[i] = i;
            else
                prefix[i] = i - st.peek() - 1;
            st.push(i);
        }

         st = new Stack<>();
        int[] suffix = new int[arr.length];

        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                suffix[i] = arr.length - 1 - i;
            } else {
                suffix[i] = st.peek() - i - 1;
            }

            st.push(i);
        }

        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(i, arr, d, 1,prefix,suffix);
            if(max==arr.length) break;
        }
        return max;
    }

    public void dfs(int idx, int[] arr, int d, int count,int[] prefix,int[] suffix) {

        if(memo[idx][count]!=-1) return ;
        
        // check both side if possible to go
        // left side - prefix 
        for(int i=idx-1;i>=Math.max(idx-d,idx-prefix[idx]);i--){
            dfs(i,arr,d,count+1,prefix,suffix);
        }

        // right side - suffix 
        for(int i=idx+1;i<=Math.min(idx+d,idx+suffix[idx]);i++){
          dfs(i,arr,d,count+1,prefix,suffix);
        }


        max=Math.max(max,count);
        memo[idx][count]=max;
    }
}