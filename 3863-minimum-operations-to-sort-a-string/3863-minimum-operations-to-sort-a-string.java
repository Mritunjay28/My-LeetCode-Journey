class Solution {
    public int minOperations(String s) {
        int n =s.length();
        if(s.length()==1) return 0;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
         boolean whole=true;
        for(int i=0;i<n;i++){
            if(arr[i]!=s.charAt(i)){
                whole=false;
                break;
            }
        }

        if(whole) return 0;
        if(s.length()==2) return -1;
        
        boolean start = false;
        for(int i=0;i<n;i++){
            if(arr[i]==s.charAt(i)){
                start=true;
            }
            else break;
        }
        boolean end = false;
        for(int i=n-1;i>=0;i--){
            if(arr[i]==s.charAt(i)){
                end=true;
            }
            else break;
        }

       
        if(start || end) return 1;

        boolean minlast = (s.charAt(n-1)==arr[0] && arr[0] !=arr[1]) ;
        boolean maxfirst = (s.charAt(0)==arr[n-1] && arr[n-1] !=arr[n-2]) ;
    
        if(minlast && maxfirst) return 3;
        
        return 2;

    }
}

// if start and end already ascending then 1 else 2 
// sort whole string and compare if any part from start and end same 