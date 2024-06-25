class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile: piles){
            right = Math.max(pile, right);
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            int total = 0;
            
            for (int p : piles)
                total += (p + mid - 1) / mid;
            if (total > h)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}