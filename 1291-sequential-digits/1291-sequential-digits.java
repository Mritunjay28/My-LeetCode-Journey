class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int l1=0;
        int x = low;
        while(x>0){
            x/=10;
            l1++;
        }

        int l2=0;
        x = high;
        while(x>0){
            x/=10;
            l2++;
        }

        for(int i=l1;i<=l2;i++){
            int st = 1 ;
            while(st<= 10-i){
                int val=st;
                int num=0;
                for(int j=0;j<i;j++){
                    num = num*10+val;
                    val++;
                }

                if(num>=low && num<=high) ans.add(num);
                st++;
            }
        }

        return ans;
    }
}