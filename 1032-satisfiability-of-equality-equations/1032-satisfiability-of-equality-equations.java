class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equ) {
        parent = new int[26]; 
        for(int i=0;i<26;i++) parent[i]=i;
        rank = new int[26]; 
        Arrays.fill(rank,1);
        for(int i=0;i<equ.length;i++){
            String s = equ[i];
            int first = s.charAt(0)-'a';
            int second = s.charAt(3)-'a';
            boolean equal = (s.charAt(1)=='=') ? true : false;

            if(equal){
                union(first,second);
            }
            // else{
            //     int xparent=find(first);
            //     int yparent=find(second);

            //     if(xparent==yparent) return false;
            // }
        }

         for(int i=0;i<equ.length;i++){
            String s = equ[i];
            int first = s.charAt(0)-'a';
            int second = s.charAt(3)-'a';
            boolean equal = (s.charAt(1)=='=') ? true : false;

            if(!equal){
                int xparent=find(first);
                int yparent=find(second);

                if(xparent==yparent) return false;
            }
        }

        return true;
    }

    void union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);

        if(xparent==yparent) return;

        if(rank[x]>rank[y]) parent[yparent]=xparent;
        else if(rank[x]<rank[y]) parent[xparent]=yparent;
        else {
            parent[xparent]=yparent;
            rank[yparent]++;
        }

    }

    int find(int value){
        if(value==parent[value]) {
            return value;
        }
        return parent[value]=find(parent[value]);
    }


}