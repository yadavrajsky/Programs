class Solution1 {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
            arr[i]=nums[i];
        for(int i=0;i<len;i++)
        {
            nums[((i+k)%len)] =arr[i];        
        }
    }
}
class Solution2 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
       reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
                
        }
    }
}

