class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for(int j=0;j<s.length();j++){
            ans.append(s.charAt(j));
            int size= ans.length();

            if(size>=2*k && s.charAt(j)==')'){
                boolean valid= true;
                for(int i=0;i<k;i++){
                    if(ans.charAt(size-2*k+i)!='('){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    for(int i=0;i<k;i++){
                    if(ans.charAt(size-k+i)!=')'){
                        valid=false;
                        break;
                    }
                }
                } 
                if(valid) ans.setLength(size-2*k);
            }
        }

        return ans.toString();
    }
}