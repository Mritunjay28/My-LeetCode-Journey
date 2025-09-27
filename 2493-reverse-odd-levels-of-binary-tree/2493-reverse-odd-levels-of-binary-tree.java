class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();

        q1.add(root);
        int level = 0;
        while (!q1.isEmpty()) {
            int len = q1.size();
            if (level % 2 == 0) {
                for (int i = 0; i < len; i++) {
                    TreeNode curr = q1.remove();
                    if (curr.left != null) q1.add(curr.left);
                    if (curr.right != null) q1.add(curr.right);
                }
            } else {
                int i = 0, j = len - 1;
                while (i < j) {
                    TreeNode curr1 = q1.removeFirst();
                    TreeNode curr2 = q1.removeLast();
                    
                    int temp = curr1.val;
                    curr1.val = curr2.val;
                    curr2.val = temp;

                    if (curr1.left != null) q2.add(curr1.left);
                    if (curr1.right != null) q2.add(curr1.right);
                    if (curr2.right != null) q2.offerFirst(curr2.right);
                    if (curr2.left != null) q2.offerFirst(curr2.left);

                    i++;
                    j--;
                }

                while(!q2.isEmpty()){
                    q1.add(q2.poll());
                }
                
                
            }
            level++;
        }
        return root;
    }
}