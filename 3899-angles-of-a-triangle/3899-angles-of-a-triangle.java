class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);

        double[] arr = new double[3];
        // is triangle possible 
        int a = sides[0] , b = sides[1] , c = sides[2] ;
        if(!(a+b>c) || !(b+c>a) || !(a+c>b)) return new double[] {};

         arr[0] = Math.toDegrees(Math.acos(
            (b*b + c*c - a*a) / (2.0 * b * c)
        ));
        
        arr[1] = Math.toDegrees(Math.acos(
            (a*a + c*c - b*b) / (2.0 * a * c)
        ));
        
        arr[2] = Math.toDegrees(Math.acos(
            (a*a + b*b - c*c) / (2.0 * a * b)
        ));
        Arrays.sort(arr);
        return arr;
    }
}