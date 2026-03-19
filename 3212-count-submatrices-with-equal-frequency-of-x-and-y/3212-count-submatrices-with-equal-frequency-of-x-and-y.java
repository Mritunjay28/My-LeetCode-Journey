class Solution {
    class Pair {
        int first;
        int second;

        Pair(int f , int s ){
            this.first = f;
            this.second = s;
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Pair[][] p = new Pair[n][m];

        for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        p[i][j] = new Pair(0, 0);
    }
}

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    if(grid[i][j]=='X') {
                        p[i][j].first = 1;
                    }
                    else if(grid[i][j] == 'Y'){
                        p[i][j].second = 1;
                    }
                }

                else if (i==0) {
                    p[i][j].first = p[i][j-1].first;
                    p[i][j].second = p[i][j-1].second;
                     if(grid[i][j]=='X') {
                        p[i][j].first += 1;
                    }
                    else if(grid[i][j] == 'Y'){
                        p[i][j].second +=1;
                    }
                }

                else if (j==0) {
                    p[i][j].first = p[i-1][j].first;
                    p[i][j].second = p[i-1][j].second;
                     if(grid[i][j]=='X') {
                        p[i][j].first += 1;
                    }
                    else if(grid[i][j] == 'Y'){
                        p[i][j].second +=1;
                    }
                }

                else {
                    p[i][j].first += p[i-1][j].first;
                    p[i][j].second += p[i-1][j].second;
                     p[i][j].first += p[i][j-1].first;
                    p[i][j].second += p[i][j-1].second;
                     p[i][j].first -= p[i-1][j-1].first;
                    p[i][j].second -= p[i-1][j-1].second;

                     if(grid[i][j]=='X') {
                        p[i][j].first += 1;
                    }
                    else if(grid[i][j] == 'Y'){
                        p[i][j].second +=1;
                    }
                }

                if(p[i][j].first==p[i][j].second && p[i][j].first>0) count++ ;
            }
        }

        return count;
    }
}