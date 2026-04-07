class Robot {
    int minx = 0, miny = 0;
    int maxx;
    int maxy;
    int x = 0, y = 0;
    int dir = 0; // east
    int cycle;

    public Robot(int width, int height) {
        maxx = width - 1;
        maxy = height - 1;
        cycle = 2 * (width + height) - 4;
    }

    public void step(int num) {
        num%=cycle;
        if (num == 0 && x == 0 && y == 0) {
            dir = 4; 
            return;
        }
        while (num > 0) {
            if (dir == 0) {
                if (x + num <= maxx){
                    x += num;
                    num=0;
                } 
                else {
                    int diff = x + num - maxx;
                    x = maxx;
                    dir++;
                    num = diff;
                }
            }
            else if (dir == 1) {
                if (y + num <= maxy){
                    y += num;
                    num=0;
                }
                else {
                    int diff = y + num - maxy;
                    y = maxy;
                    dir++;
                    num = diff;
                }
            }
            else if (dir == 2) {
                if (x - num >=0){
                    x -= num;
                    num=0;
                } 
                else {
                    int diff = num-x;
                    x = 0;
                    dir++;
                    num = diff;
                }
            }
            else{
                 if (y - num >=0){
                    y -= num;
                    num=0;
                }
                else {
                    int diff = num-y;
                    y = 0;
                    dir=0;
                    num = diff;
                }
            }

        }
    }

    public int[] getPos() {
        return new int[] {x,y};
    }

    public String getDir() {
        if(dir==0) return "East";
        else if(dir==1) return "North";
        else if(dir==2) return "West";
        else return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */