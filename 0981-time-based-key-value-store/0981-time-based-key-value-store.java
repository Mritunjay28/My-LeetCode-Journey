class TimeMap {
    class Pair {
        int num;
        String text;

        Pair(int num, String text) {
            this.num = num;
            this.text = text;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp,value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        String prev = "";
        List<Pair> temp = map.get(key);

        int s =0, e=temp.size()-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            Pair def = temp.get(mid);
            if(def.num<=timestamp){
                prev=def.text;
                s=mid+1;
            }
            else {
                e=mid-1;
            }
        }

        return prev;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */