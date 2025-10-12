class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         HashSet<String> set = new HashSet<>();
        for (int i = 0; i <wordList.size(); i++)
            set.add(wordList.get(i));

        int mutation = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

       

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String curr = q.poll();
                char[] arr = curr.toCharArray();
                if (curr.equals(endWord))return mutation+1;

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (int k=0;k<26;k++) {
                        char ch = (char)(k+'a');
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
        return 0;
    }
}