class Solution {
    int[] rank ;
    int[] parent ;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++) parent[i]= i;
            
        Map<String, Integer> emailToAccount = new HashMap<>();

       // Union accounts sharing an email
        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                   union(i, emailToAccount.get(email));
                }
            }
        }

        // root -> emails
        Map<Integer, TreeSet<String>> merged = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = find(i);

            merged.putIfAbsent(root, new TreeSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                merged.get(root).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (int root : merged.keySet()) {

            List<String> list = new ArrayList<>();

            list.add(accounts.get(root).get(0));

            list.addAll(merged.get(root));

            ans.add(list);
        }

        return ans;

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