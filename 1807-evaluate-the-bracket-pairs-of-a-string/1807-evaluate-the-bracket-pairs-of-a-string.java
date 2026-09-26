class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String ,String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        int l=-1,r=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') l=i;
            else if(s.charAt(i)==')') {
                r=i;
                String key = s.substring(l+1,r);
                
                sb.append(map.getOrDefault(key, "?"));
                
                l=r;
                continue;
            }
            else if(l==r) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}