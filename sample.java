// Time Complexity : O(n*2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, compilation error plus logical error

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
// Your code here along with comments explaining your approach
