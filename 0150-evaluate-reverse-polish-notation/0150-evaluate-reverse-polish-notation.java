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

// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> stack = new Stack();
//         int n = tokens.length;
        
//         for(String i : tokens){
//             if (i.matches("-?\\d+")) {
//                 stack.push(Integer.parseInt(i));
//             }
//             else {
//                 int temp1 = stack.pop();
//                 int temp = stack.pop();
//                 int temp2;
                
//                 if(i.equals("+")){
//                     temp2 = temp+temp1;
//                 }
//                 else if(i.equals("-")){
//                     temp2 = temp-temp1;
//                 }
//                 else if(i.equals("*")){
//                     temp2 = temp*temp1;
//                 }
//                 else if(i.equals("/")){
//                     temp2 = temp/temp1;
//                 }
//                 else{
//                     throw new IllegalArgumentException(i);
//                 }
//                 stack.push(temp2);
//             }
//         }
//         return stack.peek();
//     }
// }