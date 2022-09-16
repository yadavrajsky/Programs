class Solution {
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (c[i]) {
                case 'I':
                    if (i + 1 != c.length && c[i + 1] == 'V') {
                        sum += 4;
                        i++;
                    } else if (i + 1 != c.length && c[i + 1] == 'X') {
                        sum += 9;
                        i++;
                    } else
                        sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (i + 1 != c.length && c[i + 1] == 'L') {
                        sum += 40;
                        i++;
                    } else if (i + 1 != c.length && c[i + 1] == 'C') {
                        sum += 90;
                        i++;
                    } else
                        sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (i + 1 != c.length && c[i + 1] == 'D') {
                        sum += 400;
                        i++;
                    } else if (i + 1 != c.length && c[i + 1] == 'M') {
                        sum += 900;
                        i++;
                    } else
                        sum += 100;
                    break;
                case 'D':
                    sum += 500;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}