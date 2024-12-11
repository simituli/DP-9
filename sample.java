// Time Complexity : O(n*2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, compilation error plus logical error
//https://leetcode.com/problems/longest-increasing-subsequence/
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
    //Second Solution
    // Time Complexity : O(nLog(n))
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : yes, compilation error plus logical error
    public int lengthOfLIS(int[] nums) 
    {
            int n = nums.length;
            int[] arr = new int[n];
            arr[0] = nums[0];
            int len = 1;
            for(int i=1; i<n;i++)
            {
                if(nums[i]> arr[len-1])
                {
                    arr[len]=nums[i];
                    len++;
                }
                else
                {
                    int bsIndex = binarySearch(arr, 0, len-1, nums[i]);
                    arr[bsIndex] = nums[i];// replace the just larger number with the current number
                }
            }
            return len;
    }
    private int binarySearch(int[] nums, int low, int high, int target)
    {
            while(low<=high)
            {
                int mid= low+ (high-low)/2;
                if(nums[mid] == target) return mid;
                if(nums[mid]< target)
                {
                    low = mid+1;
                }
                if(nums[mid] > target)
                {
                    high = mid-1;
                }
            }
            return low;
    }
}
// Your code here along with comments explaining your approach
//Second problem: Russian dolls envelope