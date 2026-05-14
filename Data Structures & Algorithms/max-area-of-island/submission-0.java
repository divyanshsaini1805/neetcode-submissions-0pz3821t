class Solution {

    private int solve(int i, int j, int[][] grid, boolean[][] vis) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;

        if (grid[i][j] == 0 || vis[i][j])
            return 0;

        vis[i][j] = true;

        return 1 + solve(i + 1, j, grid, vis) + solve(i - 1, j, grid, vis)
        + solve(i, j - 1, grid, vis)
        + solve(i, j + 1, grid, vis);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    ans = Math.max(ans ,solve(i, j, grid, vis));
                }
            }
        }

        return ans;
    }
}