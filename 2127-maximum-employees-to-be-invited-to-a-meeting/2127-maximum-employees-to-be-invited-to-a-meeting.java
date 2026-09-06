class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = 0;

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == favorite[favorite[i]]) { // Isolating 2-Cycles & Building a Reverse Tree
                if (i < favorite[i]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(favorite[i]);
                    pairs.add(pair);
                }
            } else {
                graph.get(favorite[i]).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        for (List<Integer> pair : pairs) { // Summing All Extended 2-Cycles
            answer += dfs(graph, pair.get(0), visited) + dfs(graph, pair.get(1), visited);
        }

       // 0: unvisited, 1: visiting in current path, 2: fully resolved
        int[] state = new int[n];
        int circleMax = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || state[i] != 0) continue;

            int curr = i;
            // Walk forward until hitting an already-seen node or a 2-cycle node
            while (!visited[curr] && state[curr] == 0) {
                state[curr] = 1;
                curr = favorite[curr];
            }

            // Only count cycle if curr was reached within THIS current path
            if (state[curr] == 1) {
                int count = 1;
                int temp = favorite[curr];
                while (temp != curr) {
                    count++;
                    temp = favorite[temp];
                }
                circleMax = Math.max(circleMax, count);
            }

            // Mark the entire path as fully processed (state = 2)
            curr = i;
            while (!visited[curr] && state[curr] == 1) {
                state[curr] = 2;
                curr = favorite[curr];
            }
        }

        return Math.max(circleMax, answer);
    }

    private int dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int max = 0;
        for (int neighbor : graph.get(node)) {
            max = Math.max(max, dfs(graph, neighbor, visited));
        }
        return max + 1;
    }
}

/*
have need like if a -> b and for same a can max 2 for each but 1 is  the requirement then other is free
so have to fing first people like a > b , b-> a then only we can start or by like transitivity a->c , c->b,b->a

so it like dSU i think like 

0-3 3-parent , 0 child, 3-0
1-0 0 parent , 1 child 3-0,1
2-1, 3-0,1,2
3-4 
4-1

2-1,4-1 
0-3
1-0
3-4


so how to do ?
first loop must be their 
have to select largest loop - length is answer 
for loop start with x then end on x
so like for each i , check max length loop


but have problem when like have looplike a->b,b->a , a->c , as a and b form loop we can find them but a->c is not counted

i am lost not able to think now .
*/