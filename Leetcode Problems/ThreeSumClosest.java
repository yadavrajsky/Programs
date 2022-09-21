class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int closest_sum = nums[i] + nums[1] + nums[nums.length - 1];
        for (i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];
                if (currentSum > target)
                    k--;
                else
                    j++;
                if ((Math.abs(currentSum - target)) < (Math.abs(closest_sum - target)))
                    closest_sum = currentSum;
            }
        }
        return closest_sum;
    }
}