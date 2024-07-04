class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)    return 0;
        Set<Integer> set = new HashSet();
        int ans = 1;
        
        for(int num: nums){
            set.add(num);
        }
        
        for(int num: set){
                                    
            if(!set.contains(num - 1)){
                int curStreak = 1;
                while(set.contains(num + 1)){
                    num++;
                    curStreak ++;
                }
                ans = Math.max(ans, curStreak);
            }
            if(ans>nums.length/2)   break;
        }
        return ans;
    }
}