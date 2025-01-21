class Solution {
    public long gridGame(int[][] grid) {
        long fSum=0,sSum=0;
        long min=Long.MAX_VALUE;
        int m=grid[0].length,i;
        for(i=0;i<m;i++)
            fSum+=grid[0][i];
        for(i=0;i<m;i++)
        {
            fSum-=grid[0][i];
            min=Math.min(min,Math.max(fSum,sSum));
            sSum+=grid[1][i];
        }
        return min;
    }
}