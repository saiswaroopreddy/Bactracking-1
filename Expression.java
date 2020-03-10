class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        dfs(result, num, target,"",0,0,0);
        return result;
    }
    
    public void dfs(List<String> result, String num, int target, String expression, int value, int presign, int index){
        if(index == num.length()){
        if(value == target){result.add(expression);}
            return;
        }
        for(int i = index;i<num.length();i++){
            int operand = Integer.parseInt(num.substring(index, i+1));
        if(index == 0)
            dfs(result, num, target, "" + operand, operand, operand, i+1);
            
        //+
        dfs(result, num, target, expression +"+"+operand, value + operand, operand, i+1);
        dfs(result, num, target, expression + "-"+operand, value - operand, -1*operand, i+1);
        dfs(result, num, target, expression + "*"+operand, value - presign + operand*presign, operand*presign, i+1);
            }
    }
}
