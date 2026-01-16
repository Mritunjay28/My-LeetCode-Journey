class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h = totalgap(m,hFences);
        Set<Integer> v = totalgap(n,vFences);

        long area =-1;
        for(int x : h){
            if(v.contains(x)){
                area=(long)Math.max((long)x*x ,area);
            }
        }

        return (area==-1) ? -1 : (int)(area%1000000007);
    }

    public Set<Integer> totalgap(int border,int[] fences){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(border);
        for(int i=0;i<fences.length;i++) list.add(fences[i]);
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                 set.add(list.get(j)-list.get(i));
            }
        }

        return set;
    }
}