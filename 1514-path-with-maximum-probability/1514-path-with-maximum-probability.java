class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new double[] { edges[i][1], succProb[i] });
            adj.get(edges[i][1]).add(new double[] { edges[i][0], succProb[i] });
        }

        // max heap based on probability
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[1], a[1])
        );

        double[] prob = new double[n];
        prob[start_node] = 1.0;

        pq.add(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double currProb = curr[1];

            if (node == end_node) return currProb;

            for (double[] nei : adj.get(node)) {
                int next = (int) nei[0];
                double newProb = currProb * nei[1];

                if (newProb > prob[next]) {
                    prob[next] = newProb;
                    pq.add(new double[]{next, newProb});
                }
            }
        }

        return 0.0;

    }
}