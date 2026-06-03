class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        for(char ch : t.toCharArray()){
           arr[ch]++;
        }

        int st=0,e=0,ans=Integer.MAX_VALUE,counter=t.length();
        int minstart=0;
        while(e<s.length()){
            arr[s.charAt(e)]--;
            if( arr[s.charAt(e)] >= 0) counter--;

            while(counter==0){
                if(ans>e-st+1){
                    ans=e-st+1;
                    minstart=st;
                }
                arr[s.charAt(st)]++;
                if(arr[s.charAt(st)]==1) counter++;
                st++;
            }

            e++;
        }

        return (ans==Integer.MAX_VALUE)? "" : s.substring(minstart,minstart+ans);

    }
}