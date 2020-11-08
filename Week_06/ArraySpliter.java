class ArraySpliter {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len + 1][m + 1];
        int[] sum = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i -1];
            int min = Math.min(i, m);
            for (int j = 1; j <= min; j++) {
                if (j == 1)
                    dp[i][1] = sum[i];
                else
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
            }
        }
        return dp[len][m];
    }
}