class Solution {
    public int maxChunksToSorted(int[] arr) {
      Stack<Integer> stack = new Stack<>();
      for(int i=0;i<arr.length;i++){
        if(stack.isEmpty() || arr[i]>=stack.peek()) stack.push(arr[i]);
        else{
            int currmax = stack.pop();
            while(!stack.isEmpty() && arr[i] < stack.peek()) stack.pop();
            stack.push(currmax);
        }
        }
      
      return stack.size();

    }
}

/* 
if continues decresing then take them in same chuck
if increasing then different chuck 
location maximum value is to find as tell us if at start of arr answer 
thinking of monotonic stack count increase when when greater no come 
and stack become empty increase count
thinking like if minidx<maxidx then only possible 

21344
12344

5,100,3,100,1
1,3,5,100,100
*/