class Solution {
    int n, m;

    public long minTime(int[] skill, int[] mana) {
        n = skill.length;
        m = mana.length;
        long t =0;
        long[] prev= new long[n];
        long r=0;

        for(int j=0;j<m;j++){
            if(t!=0) {
                long ans= -1;
                long s= prev[0],e=prev[n-1]+1;
                while(s<=e){
                long mid = s+(e-s)/2;
                if(check(skill,mana,prev,mid,j)){
                    ans=mid;
                    e=mid-1;
                }
                else s=mid+1;
                }
                t=ans;
            }
            for(int i=0;i<n;i++){
                t+= skill[i]*mana[j];
                prev[i]=t;
            }
            r=t;
        }

        return r;
    }

    private boolean check(int[] skill, int[] mana, long[] prev,long st,int j) {
        long last=0;
        for(int i=0;i<n;i++){
            st+=skill[i]*mana[j];
            if(i!=0 && prev[i]>last) return false;
            last=st;
        }
        return true;
    }
}