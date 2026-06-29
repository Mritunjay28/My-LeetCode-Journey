class Solution {
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<word.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<word.length();j++){
                sb.append(word.charAt(j));
                set.add(sb.toString());
            }
        }

        int count=0;
        for(String x : patterns) if(set.contains(x)) count++;

        return count;
    }
}