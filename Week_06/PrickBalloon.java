 class PrickBalloon {
	public static int maxCoins4DP(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;
        length = nums2.length;
        length = nums2.length;
        int[][] dp = new int[length][length];
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length-1];
    }
 }	