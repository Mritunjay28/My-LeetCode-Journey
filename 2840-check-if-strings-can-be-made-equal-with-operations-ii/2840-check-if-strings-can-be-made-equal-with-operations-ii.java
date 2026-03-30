class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        HashMap<Character,Integer> even = new HashMap<>();
        HashMap<Character,Integer> odd = new HashMap<>();

        for(int i=0;i<n;i++) {
            if(i%2==0) even.put(s1.charAt(i),even.getOrDefault(s1.charAt(i),0)+1);
            else odd.put(s1.charAt(i),odd.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0;i<n;i++) {
            if(i%2==0){
                if(!even.containsKey(s2.charAt(i))) return false;
                even.put(s2.charAt(i),even.get(s2.charAt(i))-1);
                if(even.get(s2.charAt(i))==0) even.remove(s2.charAt(i));
            }
            else {
                 if(!odd.containsKey(s2.charAt(i))) return false;
                odd.put(s2.charAt(i),odd.get(s2.charAt(i))-1);
                if(odd.get(s2.charAt(i))==0) odd.remove(s2.charAt(i));
            }
        }

        return true;
    }
}