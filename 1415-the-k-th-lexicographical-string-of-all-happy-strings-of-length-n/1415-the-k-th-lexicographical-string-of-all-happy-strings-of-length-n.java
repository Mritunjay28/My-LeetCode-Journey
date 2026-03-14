class Solution {
    public String getHappyString(int n, int k) {
        // but we want only string not containing consicutive alphabets 
        int count = 3*(int)Math.pow(2,n-1); 
        if(k>count) return "";
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursive(arr,0,n,sb);
        return arr.get(k-1);
    }

    public void recursive(ArrayList<String> arr,int i,int n,StringBuilder sb ){
        if(i==n){
            arr.add(sb.toString());
            return;
        }
    
        if(i==0){
            sb.append('a');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('b');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('c');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else{
            if(sb.charAt(i-1)=='a'){
                 sb.append('b');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('c');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
            }
            else if(sb.charAt(i-1)=='b'){
                sb.append('a');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('c');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
            }
            else{
                sb.append('a');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('b');
            recursive(arr,i+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}