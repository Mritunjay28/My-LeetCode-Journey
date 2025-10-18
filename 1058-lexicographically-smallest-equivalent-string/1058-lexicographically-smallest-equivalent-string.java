class Solution {
    StringBuilder str= new StringBuilder();
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++) adj.add(new ArrayList<>());

        for(int i=0;i<s1.length();i++){
            adj.get(s1.charAt(i)-'a').add(s2.charAt(i)-'a');
            adj.get(s2.charAt(i)-'a').add(s1.charAt(i)-'a');
        }

        char[] min = new char[26];

        for(int i=0;i<baseStr.length();i++){
            if((int)min[baseStr.charAt(i)-'a']=='0') str.append(min[baseStr.charAt(i)-'a']);
            else{
                min[baseStr.charAt(i)-'a'] = dfs(baseStr.charAt(i),-1,new boolean[26],adj);
                str.append(min[baseStr.charAt(i)-'a']);
            }
        } 

        return str.toString();
    }

    private char dfs(char u ,int parent ,boolean[] visited,List<List<Integer>> adj){
        visited[u-'a']=true;
        int val= u-'a';
        char last = u;
        for(int v : adj.get(val)){
            if(!visited[v]){
                 char ch = dfs((char)(v+'a'),val,visited,adj);
            if(ch < last) last=ch;
            } 
        }
        return last;
    }
}