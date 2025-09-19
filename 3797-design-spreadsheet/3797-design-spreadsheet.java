class Spreadsheet {

    int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];
        // character index column is = ch-'A' 
    }

    public void setCell(String cell, int value) {
        int row = 0, col = 0;
        col = cell.charAt(0) - 'A';
        row = Integer.valueOf(cell.substring(1, cell.length()));
        arr[row-1][col] = value;
    }

    public void resetCell(String cell) {
        int row = 0, col = 0;
        col = cell.charAt(0) - 'A';
        row = Integer.valueOf(cell.substring(1, cell.length()));
        arr[row-1][col] = 0;
    }

    public int getValue(String formula) {
        int row1=0,col1=0,row2=0,col2=0 ;
        int num1=0,num2=0;
        if(Character.isDigit(formula.charAt(1))){
            int num=0,i=1;
            while(formula.charAt(i)!='+'){
            num=num*10+(formula.charAt(i)-'0');
            i++;
            }
            num1=num;
            num=0;
            i++;
            if(Character.isDigit(formula.charAt(i))){
                while(i<formula.length()){
                    num=num*10+(formula.charAt(i)-'0');
                    i++;
                }
                num2=num;
                return num1+num2;
            }
            else{
                col2=formula.charAt(i)-'A';
                i++;
                 while(i<formula.length()){
                    num=num*10+(formula.charAt(i)-'0');
                    i++;
                }
                row2=num;
                return num1+arr[row2-1][col2];
            }

        }
        else {
           col1=formula.charAt(1)-'A';
           int num=0,i=2; 
           while(formula.charAt(i)!='+'){
            num=num*10+(formula.charAt(i)-'0');
            i++;
            }
            row1=num;
            num=0;
            i++;
            if(Character.isDigit(formula.charAt(i))){
                while(i<formula.length()){
                    num=num*10+(formula.charAt(i)-'0');
                    i++;
                }
                num2=num;
                return arr[row1-1][col1]+num2;
            }
            else{
                col2=formula.charAt(i)-'A';
                i++;
                 while(i<formula.length()){
                    num=num*10+(formula.charAt(i)-'0');
                    i++;
                }
                row2=num;
                return arr[row1-1][col1]+arr[row2-1][col2];
            }
        }
        
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */