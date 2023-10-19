class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int start = 0;
        int end = n-1;
        
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(target == nums[mid]) 
                return mid;
            if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}