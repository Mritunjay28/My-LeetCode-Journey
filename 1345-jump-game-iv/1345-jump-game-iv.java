class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<int[]> q  = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[0]=true;
        q.add(new int[] {0,arr[0]});

        int l=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] temp = q.poll();
                if(temp[0]==arr.length-1) return l;

                boolean prev=false;
                boolean next =false;

                for(int x : map.get(temp[1])){
                    if(visited[x]) continue;
                    if(x==temp[0]-1) prev=true;
                    if(x==temp[0]+1) next=true;
                    q.add(new int[] {x,temp[1]});
                    visited[x]=true;
                }

                // Important to remove TLE 
                map.get(temp[1]).clear();

                if(temp[0]-1 >=0 && !prev && !visited[temp[0]-1]){
                     q.add(new int[] {temp[0]-1,arr[temp[0]-1]});
                     visited[temp[0]-1]=true;
                } 
                if(temp[0]+1 <arr.length && !next && !visited[temp[0]+1]){
                     q.add(new int[] {temp[0]+1,arr[temp[0]+1]});
                     visited[temp[0]+1]=true;
                }

                 
            }
            l++;
        }

        return -1;


    }
}

/*
[100,-23,-23,404,100,23,23,23,3,404]
 0    1   2   3   4  5  6  7  8  9

how to make connection ?
each index - for i , add i-1,i+1 then all same value 

have a hashmap to store same value idx 

100-0,4
-23=1,2
404-3,9
23-5,6,7
3-8


now in queue add int[] with {idx,arr[idx]}
in bfs pop it and have a check if it's idx = arr.length-1
else for that arr[idx] add all have boolean falg if i-1 ,i+1 added or not if yes skip else add in queue 
do level wise traversal 


//  0-1,4
//  1-0,2
//  2-1,3
//  3-2,4,9
//  4-3,5,0
//  5-4,6,7
//  6-5,7
//  7-5,6,8
//  8-7,9
//  9-8,3


 find min cost from 0 to 9 , level wise bfs 

*/