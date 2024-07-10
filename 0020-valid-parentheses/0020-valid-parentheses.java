class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                stack.push(arr[i]);
            }
            else{
                if(stack.isEmpty())
                    return false;
                else if((stack.peek() == '(' && arr[i] == ')') || 
                        (stack.peek() == '[' && arr[i] == ']') || 
                        (stack.peek() == '{' && arr[i] == '}') ){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}