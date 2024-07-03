class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans= new int[n];
        int runningProduct = 1;
        
        //let nums = [1,2,3,4]
        
        //left pass -> product of left side of current index -> ans = [1, 1, 2, 6]
        
        for(int i = 0; i<n; i++){
            ans[i] = runningProduct;    //[0,0,0,0] -> [1,0,0,0] -> [1,1,0,0] -> [1,1,2,0] -> [1,1,2,6]
            runningProduct *= nums[i];  //                1      ->  1*1 = 1  ->  1*2 = 2  ->  2*3 = 6 
        }
        
        //right pass -> product of left side of current index therefore;
        
        //ans[i] =                         ans[i] * runningProduct;
        //ans[i] = [(1*24), (1*12), (2*4), (6*1)] -> [24,12,8,6]
        
        runningProduct = 1;
        for(int i = n-1; i>=0; i--){
            ans[i] *= runningProduct;
            runningProduct *= nums[i];
        }
        return ans;
    }
}