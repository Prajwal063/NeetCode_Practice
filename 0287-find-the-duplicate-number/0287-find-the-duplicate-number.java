class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            if (!s.add(nums[i])) {
                return nums[i];
            }
        }
        return nums.length;
    }
}