class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        // Convert the array to a list for easier manipulation
        for (int num : candidates) {
            list.add(num);
        }
        
        //recursive call
        func(list, list.size() - 1, target, new ArrayList<>(), ans);
        
        return ans;
    }  
    public void func(List<Integer> list, int i, int sum, List<Integer> list2, List<List<Integer>> ans) {
        // Base case
        if (sum == 0) {
            ans.add(new ArrayList<>(list2));
            return;
        }
        
        // Edge case: if sum becomes -ve or no elements are left
        if (sum < 0 || i < 0) {
            return;
        }

        // Exclude the current element and move to the next
        func(list, i - 1, sum, list2, ans);
        
        // Include the current element in the subsequence
        list2.add(list.get(i));
        
        // Recursively call the function with the included element
        func(list, i, sum - list.get(i), list2, ans);
        
        // Backtrack by removing the last added element
        list2.remove(list2.size() - 1);
    }
}