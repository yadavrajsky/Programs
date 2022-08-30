class Solution {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int max_length = 1;
        int st = 0, end = 0;
        int n = s.length();
        // odd length
        for (int i = 0; i < n-1; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else
                    break;
            }
            int len = r - l - 1;
            if (len > max_length)
            {
                max_length = len;
            st = l + 1;
            end = r - 1;
            }
        }
        // even length
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else
                    break;
            }
            int len = r - l - 1;
            if (len > max_length) {
                max_length = len;
                st = l + 1;
                end = r - 1;
            }

        }
        return s.substring(st, end + 1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); 
    }
}