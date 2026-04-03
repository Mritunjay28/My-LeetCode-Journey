import java.util.Arrays;

class Solution {
    class Robot {
        int pos;
        int d;

        Robot(int pos, int d) {
            this.pos = pos;
            this.d = d;
        }
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0) return 0;

        Robot[] arr = new Robot[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Robot(robots[i], distance[i]);
        }
        
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a.pos, b.pos));
        
        // first thought of prefix sum but wall[i] can 1e9 so MLE 
        // donot understand how to then use bs to solve it by sorting walls 
        Arrays.sort(walls);

        // dp[i][0] = max walls using robots 0..i, with robot i going LEFT
        // dp[i][1] = max walls using robots 0..i, with robot i going RIGHT
        int[][] dp = new int[n][2];

        int L0 = arr[0].pos - arr[0].d;
        int R0 = arr[0].pos;
        dp[0][0] = countWalls(walls, L0, R0);

        
        int rlimit = (n > 1) ? Math.min(arr[1].pos, arr[0].pos + arr[0].d) : arr[0].pos + arr[0].d;
        dp[0][1] = countWalls(walls, arr[0].pos,rlimit);

        int prev_reach =rlimit; 

        for (int i = 1; i < n; i++) {
            // Calculate boundaries, stopped by adjacent robots
            int Li = Math.max(arr[i-1].pos, arr[i].pos - arr[i].d);
            int Ri = arr[i].pos;
            int Ri_reach = (i < n - 1) ? Math.min(arr[i+1].pos, arr[i].pos + arr[i].d) : arr[i].pos + arr[i].d;

            // 1. Robot i shoots LEFT
            // Option A: i-1 shot LEFT (covered up to arr[i-1].pos). We add walls strictly > arr[i-1].pos
            int left_left = dp[i-1][0] + countWalls(walls, Math.max(Li, arr[i-1].pos + 1), Ri);
            
            // Option B: i-1 shot RIGHT (covered up to prev_reach). We add walls strictly > prev_reach
            int left_right = dp[i-1][1] + countWalls(walls, Math.max(Li, prev_reach + 1), Ri);
            
            dp[i][0] = Math.max(left_left, left_right);

            // 2. Robot i shoots RIGHT
            // Option A: i-1 shot LEFT (no overlap with i's right shot)
            int right_left = dp[i-1][0] + countWalls(walls, Ri, Ri_reach);
            
            // Option B: i-1 shot RIGHT (covered up to prev_reach). We only add walls strictly > prev_reach
            int right_right = dp[i-1][1] + countWalls(walls, Math.max(Ri, prev_reach + 1), Ri_reach);
            
            dp[i][1] = Math.max(right_left, right_right);
            
            // Update reach for the next iteration
            prev_reach = Ri_reach;
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    private int countWalls(int[] walls, int L, int R) {
        if (L > R) return 0;
        int leftIdx = lowerBound(walls, L);
        int rightIdx = upperBound(walls, R);
        return Math.max(0, rightIdx - leftIdx);
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}