class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();
        backtrack(ans, 0, 0, n, "");
        return ans;
    }
    public void backtrack(List<String> ans, int open, int close, 
    int max, String str){

        if(str.length() == max*2){
            ans.add(str);
            return;
        }
        if(open < max){
            backtrack(ans, open + 1, close, max, str +"(");
        }
        if(close < open){
            backtrack(ans, open, close + 1, max, str + ")");
        }
    }
}