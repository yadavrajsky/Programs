class Solution {
    public int reverse(int x) {
        Integer INT_MAX = Integer.MAX_VALUE;
        Integer INT_MIN = Integer.MIN_VALUE;

        if (x == 0)
            return 0;
        int reversed_number = 0;
        while (x != 0) {
            int last_digit = x % 10;
            x = x / 10;
            if ((reversed_number > INT_MAX / 10) || (reversed_number == INT_MAX / 10 && last_digit > 7))
                return 0;
            else if ((reversed_number < INT_MIN / 10) || (reversed_number == INT_MIN / 10 && last_digit < -8))
                return 0;

            reversed_number = (reversed_number * 10) + last_digit;
        }
        return reversed_number;
    }
}