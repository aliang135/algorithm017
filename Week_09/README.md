学习笔记
63. 不同路径 II
一个机器人位于一个 m ∗ n m * n m∗n 网格的左上角 （起始点在下图中标记为 “ S t a r t ” “Start” “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “ F i n i s h ” “Finish” “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 1 1 和 0 0 0 来表示。

说明： m m m 和 n n n 的值均不超过 100 100 100。

示例 1:

输入:
[
[0,0,0],
[0,1,0],
[0,0,0]
]
输出: 2
解释:
3 ∗ 3 3*3 3∗3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：

向右 -> 向右 -> 向下 -> 向下
向下 -> 向下 -> 向右 -> 向右
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

解题思路：使用动态规划，用一个二维数组dp[i][j]存储状态变量。

dp[i][j]表示从起始点到第i行第j列的不同路径的个数；
状态转移方程:
如果网格矩阵a[i-1][j]==1 || a[i][j-1]==1，状态转移方程为dp[i][j] = max(dp[i-1][j], dp[i][j-1])；
如果网格矩阵a[i][j ==1，状态转移方程为dp[i][j]=0；
如果网格矩阵a[i-1][j]==0 && a[i][j-1]==0，状态转移方程为dp[i][j] = dp[i-1][j] + dp[i][j-1]；

java 代码：
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}