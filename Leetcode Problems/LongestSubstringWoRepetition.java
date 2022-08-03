class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest_substring_length = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> mp = new HashMap();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while (i < s.length() - 1) {
                i++;
                f1 = true;
                char ch = s.charAt(i);
                // if(mp.containsKey)
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
                if (mp.get(ch) == 2) {
                    break;
                } else {
                    int length = i - j;
                    if (length > longest_substring_length)
                        longest_substring_length = length;
                }
            }
            // release
            while (j < i) {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 1)
                    break;
            }
            if (f1 == false && f2 == false)
                return longest_substring_length;
        }
    }
}