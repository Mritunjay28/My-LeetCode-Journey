class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++)
            set.add(bank[i]);

        int mutation = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        HashSet<String> visited = new HashSet<>();
        visited.add(startGene);

        char[] character = { 'A', 'C', 'G', 'T' };

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String curr = q.poll();
                char[] arr = curr.toCharArray();
                if (curr.equals(endGene))return mutation;

                for (int j = 0; j < 8; j++) {
                    char old = arr[j];
                    for (char ch : character) {
                        if (ch == old)continue;
                        arr[j] = ch;
                        String newString = new String(arr);
                        if (set.contains(newString) && !visited.contains(newString)) {
                            q.offer(newString);
                            visited.add(newString);
                        }
                    }
                    arr[j] = old;
                }
                
            }
            mutation++;
        }
        return -1;
    }
}