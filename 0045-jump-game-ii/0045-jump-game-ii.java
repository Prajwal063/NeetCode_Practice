class Solution {
    public int jump(int[] nums) {
        int n = nums.length, i = 0, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
	    while(lastJumpedPos < n - 1) {  
		    maxReachable = Math.max(maxReachable, i + nums[i]);  
		    if(i == lastJumpedPos) {			  
			    lastJumpedPos = maxReachable;     
			    jumps++;                          
		    }            
		    i++;
	    }
	    return jumps;   
    }
}