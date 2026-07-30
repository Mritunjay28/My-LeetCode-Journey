class Solution {
    public int minimumPushes(String word) {
        int cost=1;
        int total=0;

        int count=0;
        int[] arr = new int[26];

        for(char ch : word.toCharArray()) arr[ch-'a']++;

        Arrays.sort(arr);

        for(int i=25;i>=0;i--){
            if(arr[i]==0) break;
            total += (arr[i]*cost);
            count++;
            if(count==8){
                cost++;
                count=0;
            }
        }

        return total;
    }
}