class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int n = numbers.length;
        int z = n-1;

        while(a<=z){
            int sum = numbers[a] + numbers[z];
    
            if(numbers[a]+numbers[z]>target){
                z--;
            }
            else if(numbers[a]+numbers[z]<target){
                a++;
            }
            else{
                break;
            }
        }
        return new int[]{a+1, z+1};
    }
}