class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        
        int ans = 0;
        
        for(int i : nums){
            set.add(i);
        }
        
        for(int num: set){
            if(!set.contains(num - 1)){
                int cur = num;
                int curStreak = 1;
                
                    while(set.contains(cur + 1)){
                    cur += 1;
                    curStreak += 1;    
                }
                ans = Math.max(curStreak, ans);
            }
            
        }
        return ans;
    }
}