class Solution {

    private void solve(int i, int j, char[][] grid, boolean[][] vis) {

        // boundary check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        // if water or already visited
        if (grid[i][j] == '0' || vis[i][j])
            return;

        vis[i][j] = true;

        solve(i + 1, j, grid, vis);
        solve(i - 1, j, grid, vis);
        solve(i, j + 1, grid, vis);
        solve(i, j - 1, grid, vis);
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {

                    ans++;

                    solve(i, j, grid, vis);
                }
            }
        }

        return ans;
    }
}