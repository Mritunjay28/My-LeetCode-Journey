class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        List<Integer> col = new ArrayList<>();
        for(int j=0;j<mat[0].length;j++){
            boolean one =false , two=false;
            for(int i=0;i<mat.length;i++){
                if(mat[i][j]==1){
                    if(!one) one=true;
                    else if(one) two = true;
                }
            }
            if(!two && one) col.add(j);
        }

        List<Integer> row = new ArrayList<>();
        for(int j=0;j<mat.length;j++){
            boolean one =false , two=false;
            for(int i=0;i<mat[0].length;i++){
                if(mat[j][i]==1){
                    if(!one) one=true;
                    else if(one) two = true;
                }
            }
            if(!two && one) row.add(j);
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && row.contains(i) && col.contains(j)) count++;
            }
        }
        return count;
    }
}