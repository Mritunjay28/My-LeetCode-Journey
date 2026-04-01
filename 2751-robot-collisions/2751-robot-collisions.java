import java.util.*;

class Solution {
    class Robot {
        int pos, health, idx;
        char dir;
        Robot(int p, int h, int i, char d) {
            pos = p; health = h; idx = i; dir = d;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], i, directions.charAt(i));
        }

        // Sort robots by their physical position
        Arrays.sort(robots, (a, b) -> Integer.compare(a.pos, b.pos));
        
        Stack<Robot> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (robots[i].dir == 'R') {
                st.push(robots[i]);
            } else {
                // Robot moving Left encounters robots moving Right in the stack
                while (!st.isEmpty() && st.peek().dir == 'R' && robots[i].health > 0) {
                    Robot top = st.peek();
                    if (top.health < robots[i].health) {
                        st.pop();
                        robots[i].health--;
                        top.health = 0;
                    } else if (top.health > robots[i].health) {
                        top.health--;
                        robots[i].health = 0;
                    } else {
                        st.pop();
                        robots[i].health = 0;
                        top.health = 0;
                    }
                }
                // If the Left-moving robot survives all collisions, keep it
                if (robots[i].health > 0) {
                    st.push(robots[i]);
                }
            }
        }

        // Create a list of all survivors
        List<Robot> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (robots[i].health > 0) {
                survivors.add(robots[i]);
            }
        }

        // Sort by original index to maintain input order
        Collections.sort(survivors, (a, b) -> Integer.compare(a.idx, b.idx));

        List<Integer> ans = new ArrayList<>();
        for (Robot r : survivors) {
            ans.add(r.health);
        }
        return ans;
    }
}