public class Litcode35 {
    public int searchInsert(int[] nums, int target) {
        int a = 0;
        int b = nums.length-1;

        while(a<=b)
        {
            int  mid = a + (b - a) / 2;
            if(nums [mid]==target)
            {
                return mid;
            }
            if (nums[mid]<target)
            {
                a= mid+1;
            }
            if (nums[mid]>target)
            {
                b=mid-1;
            }
        }
        return a;
    }
}