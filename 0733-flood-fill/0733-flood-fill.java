class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length , n=image[0].length;

        dfs(sr,sc,image,color,image[sr][sc]);

        return image;
    }

    public void dfs(int i,int j,int[][] image,int c , int p ){
        int m = image.length , n=image[0].length;
        image[i][j]=c;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] d : dir){
            int x = i+d[0] , y= j+d[1];

            if(x>=0 && x<m && y>=0 && y<n && image[x][y]==p ){
                dfs(x,y,image,c,p);
            }
        }
    }
}