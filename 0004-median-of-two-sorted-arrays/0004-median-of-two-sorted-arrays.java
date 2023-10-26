class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0.000000;
        int n = nums1.length;
        int m = nums2.length;
        
        int[] arr = new int[m+n];
        int i = 0;
        for(int e: nums1){
            arr[i] = e;
            i++;
        }
        for(int e: nums2){
            arr[i] = e;
            i++;
        }
        Arrays.sort(arr);
        int l = arr.length;
        
            
        if(l % 2 != 0)
           
            return (double)arr[l/2];
        else 
            return (double)(arr[(l-1)/2] + arr[l/2])/2.0;
        
        
    }
}