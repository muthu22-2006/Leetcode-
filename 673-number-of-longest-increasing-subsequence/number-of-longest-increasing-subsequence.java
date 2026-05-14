class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];

        int maxLen = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {

                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }

                    else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (len[i] > maxLen) {
                maxLen = len[i];
                ans = cnt[i];
            } 
            else if (len[i] == maxLen) {
                ans += cnt[i];
            }
        }

        return ans;
    }
}