class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                dp[i]=nums[i];
            }
            else if(i==1){
                dp[i]=Math.max(nums[i],nums[i-1]);
            }
            else{
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        }
        return dp[n-1];
    }
}