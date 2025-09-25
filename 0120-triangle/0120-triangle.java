class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                int upper=10000000;
                if(j <triangle.get(i-1).size()) upper=triangle.get(i-1).get(j);
                int upperleft=10000000;
                if(j-1 >=0) upperleft=triangle.get(i-1).get(j-1);
                triangle.get(i).set(j, Math.min(upper+triangle.get(i).get(j),upperleft+triangle.get(i).get(j) ));
            }
        }

        int min=10000000;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            min=Math.min(min,triangle.get(triangle.size()-1).get(i));
        }
        return min;
    }
}