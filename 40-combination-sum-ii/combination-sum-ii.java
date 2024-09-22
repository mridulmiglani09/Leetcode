class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, candidates, target, ans, current);
        return ans;
    }
    public void backtrack(int index, int [] nums, int sum,
    List<List<Integer>> ans, List<Integer> current){
        if(sum == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(sum < 0){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (nums[i] > sum) break;

            current.add(nums[i]);
            backtrack(i + 1, nums, sum - nums[i], ans, current);
            current.remove(current.size() - 1);
        }
    }
}