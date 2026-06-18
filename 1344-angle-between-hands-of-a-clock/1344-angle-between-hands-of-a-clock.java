class Solution {
    public double angleClock(int hour, int minutes) {
        double minutesAngle  = minutes*6;
        double hourAngle  = hour*5*6;
        double hourIncrease = (double) minutes/2;

        double angle = Math.abs(minutesAngle-hourAngle-hourIncrease);

        return Math.min(angle,360-angle);

    }
}