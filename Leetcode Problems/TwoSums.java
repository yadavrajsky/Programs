// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=0;i<nums.length-1;i++)
//         {
//             for(int j=i+1;j<nums.length;j++)
//             {
//                 if(nums[i]+nums[j]==target)
//                     return new int[]{i,j};
//             }            
//         }
//         return new int[]{-1,-1};
//     }
// }
// class Solution {
// public int[] twoSum(int[] nums, int target) {
// HashMap hm=new HashMap();
// for(int i=0;i<nums.length;i++)
// {
// if(hm.containsKey(target-nums[i]))
// return new int[]{i,(Integer)hm.get(target-nums[i])};
// hm.put(nums[i],i);
// }
// return new int[]{-1,-1};
// }

// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]))
                return new int[] { i, (Integer) hm.get(target - nums[i]) };
            hm.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}