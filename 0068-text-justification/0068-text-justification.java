class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i=0;

        while(i<words.length){
            int j=i;
            int len =0;

            while(j<words.length && len+ words[j].length() + (j-i) <=maxWidth){
                len+= words[j].length();
                j++;
            }

            int gaps = j-1-i;
            StringBuilder sb = new StringBuilder();

            if(j== words.length || gaps==0){
                for(int k=i;k<j;k++) {
                    sb.append(words[k]);
                    if(k!=j-1) sb.append(" ");
                }

                while(sb.length() < maxWidth) sb.append(" ");
            }
            else{
                int space = maxWidth - len;
                int even = space / gaps;
                int extra = space % gaps;

                 for(int k=i;k<j;k++) {
                    sb.append(words[k]);
                    if(k!=j-1){
                        for(int l=0;l<even;l++) sb.append(" ");
                        if(extra-- > 0) sb.append(" ");
                    } 
                }
            }

            res.add(sb.toString());
            i=j;
        }

        return res;
    }
}