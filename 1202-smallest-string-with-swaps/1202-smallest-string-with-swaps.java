class Solution {
    int[] rank ;
    int[] parent ;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++) parent[i]= i;

        for(int i=0;i<pairs.size();i++){
            int u=pairs.get(i).get(0);
            int v=pairs.get(i).get(1);

            union(u,v);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
        int root = find(i);
        groups.putIfAbsent(root, new ArrayList<>());
        groups.get(root).add(i);
        }

         char[] ans = s.toCharArray();

        
        for (List<Integer> indices : groups.values()) {

            List<Character> chars = new ArrayList<>();

           
            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }

           
            Collections.sort(indices);
            Collections.sort(chars);

          
            for (int i = 0; i < indices.size(); i++) {
                ans[indices.get(i)] = chars.get(i);
            }
        }

        return new String(ans);


    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
                parent[py] = px;
                rank[px]++;
        }
    }
}