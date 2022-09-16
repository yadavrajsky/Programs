class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int i = 0, j = height.length - 1;
        int max_area = 0;
        while (i < j) {
            if (height[i] == 0) {
                i++;
                continue;
            } else if (height[j] == 0) {
                j--;
                continue;
            }
            int x = j - i;
            int y = Math.min(height[i], height[j]);
            int area = x * y;
            if (height[j] > height[i])
                i++;
            else
                j--;
            if (max_area < area)
                max_area = area;
        }
        return max_area;
    }
}