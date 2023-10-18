class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        
        int n = heights.length;
        
        int[] prevMin = prevSmaller(heights);
        int[] nextMin = nextSmaller(heights);
        
        for(int i = 0; i<n; i++){
            int cur = (nextMin[i] - prevMin[i] - 1) * heights[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    
    public int[] prevSmaller(int[] heights){
        int n = heights.length;
        
        int[] temp = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                temp[i] = -1;
            }
            else{
                temp[i] = stack.peek();
            }
            stack.push(i);
        }
        return temp;
    }
    
    //same prevSmaller method but "traversing from back" AND "when stack is empty add length of array not -1"
    public int[] nextSmaller(int[] heights){
        int n = heights.length;
        
        int[] temp = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                temp[i] = n;
            }
            else{
                temp[i] = stack.peek();
            }
            stack.push(i);
        }
        return temp;
    }
}