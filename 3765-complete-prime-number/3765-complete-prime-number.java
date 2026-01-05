class Solution {
    public boolean completePrime(int num) {
        int x=num;
        int count=0;
        while(x>0){
           count++;
            x/=10;
        }

        for(int i=1;i<=count;i++) {
            int a = num% (int)Math.pow(10,i);
            if(!isprime(a)) return false;
        }

        for(int i=1;i<=count;i++) {
            int a = num / (int) Math.pow(10,count-i);
            if(!isprime(a)) return false;
        }
      

        return true;
    }

    public boolean isprime(int n){
        if(n==1||n==0) return false;
        if(n==2||n==3) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }

        return true;
    }
}