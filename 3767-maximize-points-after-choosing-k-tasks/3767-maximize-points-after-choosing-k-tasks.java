class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = technique1.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(technique1[i] - technique2[i]))
                map.put(technique1[i] - technique2[i], new ArrayList<>());
            map.get(technique1[i] - technique2[i]).add(i);
        }

        long ans = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.descendingMap().entrySet()) {
            List<Integer> list = e.getValue();
            for (int i = 0; i < list.size(); i++) {
                if (k > 0) {
                    ans += technique1[list.get(i)];
                    k--;
                } 
                // else if (e.getKey() >= 0) ans += technique1[list.get(i)];
                // else ans += technique2[list.get(i)];
                else ans+= Math.max(technique1[list.get(i)],technique2[list.get(i)]);
            }

        }
        return ans;

    }
}