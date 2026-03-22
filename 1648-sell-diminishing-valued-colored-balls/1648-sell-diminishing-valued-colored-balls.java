class Solution {
    public int maxProfit(int[] inventory, int orders) {
        TreeMap<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < inventory.length; i++) {
            map.put((long)inventory[i], map.getOrDefault((long)inventory[i], 0L) + 1L);
        }
        map.put(0L, 0L);

        long ans = 0;
        int mod = (int) 1e9 + 7;

        while (orders > 0) {
            Long last = map.lastKey();
            Long second = map.lowerKey(last);

            long diff = last - second;
            long count = map.get(last);

            long total = last * (last + 1) / 2;
            long sub = (last - diff) * (last - diff + 1) / 2;
            long req = total - sub;

            if (diff * count > orders) {
                long div = orders / count;
                long rem = orders % count;

                total = last * (last + 1) / 2;
                sub = (last - div) * (last - div + 1) / 2;
                req = total - sub;
                ans += req * count;
                ans = ans % mod;

                ans += (last - div) * rem;
                ans = ans % mod;

                orders = 0;

            } else {
                ans += req * count;
                ans = ans % mod;
                orders -= diff * count;
                map.remove(last);
                map.put(second, map.get(second) + count);

            }

        }

        return (int) ans;

    }

}

/*

3,6,8,2,3 

2,3,3,6,8    15

8+7 2,3,3,6,6 13

6+6+5+5+4+4  2,3,3,3,3  7

3+3+3+3  2,2,2,2,2    3

2+2+2    2,2,1,1,1    0


*/