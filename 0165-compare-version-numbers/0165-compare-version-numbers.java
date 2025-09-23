class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();

            if (i >= version1.length())
                str1.append('0');
            else {
                while (i < version1.length() && version1.charAt(i) != '.')
                    str1.append(version1.charAt(i++));
            }
            i++;

            if (j >= version2.length())
                str2.append('0');
            else {
                while (j < version2.length() && version2.charAt(j) != '.')
                    str2.append(version2.charAt(j++));
            }
            j++;

            if (Integer.parseInt(str1.toString()) > Integer.parseInt(str2.toString()))
                return 1;
            if (Integer.parseInt(str2.toString()) > Integer.parseInt(str1.toString()))
                return -1;
        }
        return 0;
    }
}