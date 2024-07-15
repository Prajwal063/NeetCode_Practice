class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //We can completely ignore the square root as we are just comparing the values (if a*a>b*b => a>b)
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->
            Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])
            )
        ); //only this is changed (swapped)
        for (int[] point : points) {
            q.add(point);
            //remove when size increase k
            if (q.size() > k) {
                q.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = q.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }
}