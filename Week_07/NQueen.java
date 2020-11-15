class NQueen {
    public List<List<String>> solveNQueens(int n) {
        int[] queens=new int[n];
        List<List<String>> results=new ArrayList<>();
        solveNQueens(results,queens,n,0,0,0,0);
        return results;
    }
    public void solveNQueens(List<List<String>> results,int[] queens,int n,int row,int columns,int diagonals1,int diagonals2){
        if(row==n){
            results.add(generateString(queens));
            return;
        }
        int availableLocations=((1<<n)-1)&(~(columns|diagonals1|diagonals2));
        diagonals1<<=1;
        diagonals2>>=1;
        while(availableLocations!=0){
            int position=availableLocations&(-1*availableLocations);
            int columnNum=Integer.bitCount(position-1);
            queens[row]=columnNum;
            availableLocations=availableLocations&(availableLocations-1);
            solveNQueens(results,queens,n,row+1,columns|position,diagonals1|position<<1,diagonals2|position>>1);
        }
    }
    public List<String> generateString(int[] queens){
        List<String> result=new ArrayList<>();
        for(int i:queens){
            char[] chars=new char[queens.length];
            Arrays.fill(chars,'.');
            chars[i]='Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }
}