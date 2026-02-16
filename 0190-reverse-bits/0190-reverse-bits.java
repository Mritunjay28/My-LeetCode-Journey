class Solution {
    public int reverseBits(int n) {
        List<Integer> list = new ArrayList<>();
        int x=n;
        while(x>0){
            int rem = x%2;
            list.add(rem);
            x/=2;
        }

        for(int i=list.size()+1;i<=32;i++) list.add(0);

        int sum=0;
        int pow =0;
        for(int i=list.size()-1;i>=0;i--){
            sum += (Math.pow(2,pow)*list.get(i));
            pow++;
        }
        return sum;
    }
}

// 10 - 1010 
// 10%2=0 , 5%2=1 , 2%2=0 , 1%2=1 
// 1000100 -  0010001
// 4 - 100 , 001