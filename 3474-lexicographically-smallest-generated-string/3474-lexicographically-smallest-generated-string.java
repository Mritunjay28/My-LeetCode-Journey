class Solution {
    public String generateString(String str1, String str2) {
        int l = str1.length() + str2.length() - 1;
        char[] sb = new char[l];
        boolean[] fixed = new boolean[l];

        // 1. Fill with 'a' by default 
        for (int i = 0; i < l; i++) {
            sb[i] = 'a';
        }

        // 2. Process 'T's 
        // This handles 'T' insertion and overlap logic safely
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < str2.length(); j++) {
                    // If it's already fixed by another 'T' and doesn't match, it's impossible
                    if (fixed[i + j] && sb[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    sb[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        // 3. Check for every 'F' if it forms s2
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'F') {
                boolean isMatch = true;
                for (int j = 0; j < str2.length(); j++) {
                    if (sb[i + j] != str2.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    // try to exchange it 
                    boolean possible = false;
                    
                    // Go from right to left to keep the string lexicographically smallest
                    for (int j = str2.length() - 1; j >= 0; j--) {
                        // Only change it if it wasn't locked by a 'T'
                        if (!fixed[i + j]) {
                            // To break the match and stay small, change 'a' to 'b'
                            if (str2.charAt(j) == 'a') {
                                sb[i + j] = 'b';
                            } else {
                                sb[i + j] = 'a'; 
                            }
                            possible = true;
                            break;
                        }
                    }
                    
                    // If we couldn't change any character (all were fixed by 'T'), it's impossible
                    if (!possible) return "";
                }
            }
        }

        return new String(sb);
    }
}

/*

tftf ab
ababa


tftf abc
abc

*/