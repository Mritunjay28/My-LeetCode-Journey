class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];

        for(int i=0;i<text.length();i++) arr[text.charAt(i)-'a']++;

        int min = Integer.MAX_VALUE;

        min =Math.min(min,arr[0]);
        min =Math.min(min,arr[1]);
        min =Math.min(min,arr[11]/2);
        min =Math.min(min,arr[14]/2);
        min =Math.min(min,arr[13]);

        return min;
    }
}