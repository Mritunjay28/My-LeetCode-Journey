class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        long n = num;
        long d = den;

        if (n * d < 0) sb.append("-");
        n = Math.abs(n);
        d = Math.abs(d);

        sb.append(n / d);
        long rem = n % d;
        if (rem == 0) return sb.toString();

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int pos = map.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / d);
            rem %= d;
        }

        return sb.toString();
    }
}
