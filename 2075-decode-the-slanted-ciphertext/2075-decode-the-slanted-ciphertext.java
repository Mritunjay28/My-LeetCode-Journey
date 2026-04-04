class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows==1) return encodedText;
         int col = encodedText.length()/rows;  
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<col;i++){
            int temp=i;
            for(int r=0;r<rows;r++){
                int val = (r*col + temp);
                if(temp>=col) break;
                sb.append(encodedText.charAt(val));
                temp++;
            }
        }

        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
    sb.setLength(sb.length() - 1); 
}

        return sb.toString();
    }
}