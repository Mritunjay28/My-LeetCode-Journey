class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}