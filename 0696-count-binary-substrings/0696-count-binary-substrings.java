class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        ArrayList<Integer> arr = new ArrayList<>();
        int count=1;
        char prev=s.charAt(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)==prev) count++;
            else {
                arr.add(count);
                count=1;
                prev=s.charAt(i);
            }
        }
        arr.add(count);

        count=0;
        for(int i=1;i<arr.size();i++) count+=Math.min(arr.get(i),arr.get(i-1));
        return count;

    }
}
