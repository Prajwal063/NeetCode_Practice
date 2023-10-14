class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int n = tokens.length;
        
        for(String i : tokens){
            if (i.matches("-?\\d+")) {
                stack.push(Integer.parseInt(i));
            }
            else {
                int temp1 = stack.pop();
                int temp = stack.pop();
                int temp2;
                
                if(i.equals("+")){
                    temp2 = temp+temp1;
                }
                else if(i.equals("-")){
                    temp2 = temp-temp1;
                }
                else if(i.equals("*")){
                    temp2 = temp*temp1;
                }
                else if(i.equals("/")){
                    temp2 = temp/temp1;
                }
                else{
                    throw new IllegalArgumentException(i);
                }
                stack.push(temp2);
            }
        }
        return stack.peek();
    }
}