class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res =0;
        int x =0,y=0;
        int dir=0;
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1){
                dir++;
                dir = dir%4;
            }
            else if (commands[i]==-2){
                dir--;
                if(dir<0) {
                    dir = (dir+4)%4;
                }
            }
            else{
                if(dir==1){
                    // check if same y exist 
                    boolean update = false;
                    int gap=-1;
                    int ans=-1;
                    for(int j =0;j<obstacles.length;j++){
                        if(obstacles[j][1]==y && obstacles[j][0]>x && x+commands[i] >=obstacles[j][0]) {
                            if(gap==-1){
                                 gap= obstacles[j][0]-x;
                             update=true;
                             ans=obstacles[j][0];
                            }
                            if(obstacles[j][0]-x<gap){
                                 update=true;
                             ans=obstacles[j][0];
                              gap= obstacles[j][0]-x;
                            }
                        }
                    }
                    if(!update) x +=commands[i];
                    else x=ans-1;
                }
                else if (dir==3){
                    // check if same y exist 
                    boolean update = false;
                     int gap=Integer.MAX_VALUE;
                    int ans=1;
                    for(int j =0;j<obstacles.length;j++){
                        if(obstacles[j][1]==y && obstacles[j][0]<x && x-commands[i] <=obstacles[j][0]) {
                            if(gap==1){
                                gap= x-obstacles[j][0];
                                update=true;
                            ans=obstacles[j][0];
                            }
                            if(x-obstacles[j][0] <gap) {
                                 update=true;
                             ans=obstacles[j][0];
                              gap= x-obstacles[j][0];
                            }
                            
                        }
                    }
                    if(!update) x -=commands[i];
                    else x=ans+1;
                }
                else if(dir==0){
                    // check same x 
                     boolean update = false;
                    int gap=-1;
                    int ans=-1;
                    for(int j =0;j<obstacles.length;j++){
                        if(obstacles[j][0]==x && obstacles[j][1]>y && y+commands[i] >=obstacles[j][1] ) {
                            if(gap==-1){
                                 gap= obstacles[j][1]-y;
                             update=true;
                             ans=obstacles[j][1];
                            }
                            if(obstacles[j][1]-y<gap){
                                 update=true;
                             ans=obstacles[j][1];
                              gap= obstacles[j][1]-y;
                            }
                        }
                    }
                    if(!update) y +=commands[i];
                    else y=ans-1;
                }
                else{
                     boolean update = false;
                     int gap=Integer.MAX_VALUE;
                    int ans=1;
                    for(int j =0;j<obstacles.length;j++){
                        if(obstacles[j][0]==x && obstacles[j][1]<y && y-commands[i] <=obstacles[j][1]) {
                            if(gap==1){
                                gap= y-obstacles[j][1];
                                update=true;
                            ans=obstacles[j][1];
                            }
                            if(y-obstacles[j][1] <gap) {
                                 update=true;
                             ans=obstacles[j][1];
                              gap= y-obstacles[j][1];
                            }
                            
                        }
                    }
                    if(!update) y -=commands[i];
                    else y=ans+1;
                }

                res= Math.max(res,x*x+y*y);
            }
        }

        return res;
    }
}