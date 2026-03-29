class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] arr = s1.toCharArray();
        int n=s1.length();
        
        for(int i=0;i<n;i++){
            if(arr[i]!=s2.charAt(i)) {
                if(i+2<n && arr[i+2]==s2.charAt(i)) {
                    char temp = arr[i];
                    arr[i]=arr[i+2];
                    arr[i+2]=temp;
                }
                else return false;
            }
        }

        return true;
    }
}