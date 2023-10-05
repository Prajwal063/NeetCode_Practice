class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int num: nums){
            s.add(num);
        }

        int ans = 0;

        for(int num: nums){
            if(!s.contains(num-1)){
                int cur = num;
                int curStreak = 1;

                while(s.contains(cur+1)){
                    cur+=1;
                    curStreak+=1;
                }
                ans = Math.max(curStreak, ans);
            }
        }
        return ans;
    }
}