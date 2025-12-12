class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n= numberOfUsers;
        int[] lo = new int[n];// lastoffline
        int[] mention = new int[n];

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 == t2) {
                // If types are different, OFFLINE should come first.
                // String comparison: "MESSAGE" vs "OFFLINE". We want OFFLINE first.
                return b.get(0).compareTo(a.get(0));
            }
            return t1 - t2;
        });

        for(int i=0;i<events.size();i++){
            String e = events.get(i).get(0);
            int t = Integer.parseInt(events.get(i).get(1));
            if(e.equals("MESSAGE")){
                char ch = events.get(i).get(2).charAt(0);
                if(ch=='A') {
                    for(int j=0;j<n;j++) mention[j]++;
                }
                else if (ch=='H'){
                    for(int j=0;j<n;j++){
                       if(lo[j] <= t) mention[j]++;
                    } 
                }
                else{
                    StringBuilder str = new StringBuilder();
                    for(int j=2;j<events.get(i).get(2).length();j++){
                        if(events.get(i).get(2).charAt(j) !=' ') str.append(events.get(i).get(2).charAt(j));
                        else{
                            int a =Integer.parseInt(str.toString());
                            mention[a]++;
                            str.setLength(0);
                            j+=2;
                        }
                    }

                     int a =Integer.parseInt(str.toString());
                        mention[a]++;

                }
            }
            else{
                int id = Integer.parseInt(events.get(i).get(2));

                lo[id]= t+ 60;
            }
        }

        return mention;
    }
}