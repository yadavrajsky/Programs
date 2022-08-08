class Solution {
    public String convert(String s, int numRows) {
        HashMap<Integer, StringBuilder> hm = new HashMap<>();
        int pos = 0;
        boolean inc = true;
        if (numRows == 1)
            return s;
        for (char c : s.toCharArray()) {
            if (pos == numRows)
                inc = false;
            else if (pos == 1)
                inc = true;
            if (inc)
                pos++;
            else
                pos--;
            if (!hm.containsKey(pos))
                hm.put(pos, new StringBuilder());
            hm.get(pos).append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int key : hm.keySet()) {
            result.append(hm.get(key));
        }
        return result.toString();
    }
}