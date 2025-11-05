class ExamTracker {

    TreeMap<Integer, Long> map;
    public ExamTracker() {
        map = new TreeMap<>();
    }
    
    long sum=0;
    public void record(int time, int score) {
         sum+=score;
        map.put(time,sum);
       
    }
    
    public long totalScore(int s, int e) {
        Map.Entry<Integer, Long> endEntry = map.floorEntry(e);
        if (endEntry == null) return 0; 

        Map.Entry<Integer, Long> startEntry = map.lowerEntry(s);
        
        long max = endEntry.getValue();
        long min = (startEntry == null) ? 0 : startEntry.getValue();

        return max - min;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */