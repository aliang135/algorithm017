class SubMatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length; int column = row == 0 ? 0 : matrix[0].length;
        if(column == 0)     return 0;
        int[][] expandMatrix = new int[row + 1][column + 1];
        for(int i = 1; i < row + 1; i++)
            expandMatrix[i][1] = matrix[i-1][0] + expandMatrix[i-1][1];
        for(int j = 1; j < column + 1; j++)
            expandMatrix[1][j] = matrix[0][j-1] + expandMatrix[1][j-1];
        for(int i = 2; i < row + 1; i++)
            for(int j = 2; j < column + 1; j++)
                expandMatrix[i][j] = expandMatrix[i-1][j] 
                    + expandMatrix[i][j-1] - expandMatrix[i-1][j-1] + matrix[i-1][j-1];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < row + 1; i++)
            for(int j = 1; j < column + 1; j++)
                for(int m = i; m < row + 1; m++)
                    for(int n = j; n < column + 1; n++)
                    {
                        int testExpr = expandMatrix[m][n] - expandMatrix[m][j-1] 
                        -  expandMatrix[i-1][n] + expandMatrix[i-1][j-1];
                        if(testExpr <= k)
                            res = Math.max(res, testExpr);
                    }
        return res;
    }
}