class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(target == nums[mid])
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}