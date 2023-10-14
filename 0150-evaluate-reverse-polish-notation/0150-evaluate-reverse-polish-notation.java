class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for(String i : tokens){
            
            
                
            if(i.equals("+")){
                int temp = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp+temp1);
            }
            else if(i.equals("-")){
                int temp = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp1-temp);
            }
            else if(i.equals("*")){
                int temp = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp*temp1);
            }
            else if(i.equals("/")){
                int temp = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp1/temp);
            }
            else{
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.peek();
    }
}