package com.test.Graphs.medium;

public class NumberOfIslands {

    static int height;
    static int width;
    static char[][] g;  // The given grid, stored to reduce recursion memory usage

    public static int numIslands(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = grid;

        int count = 0;

        // Dimensions of the given graph
        height = g.length;
        if (height == 0) return 0;
        width = g[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (g[row][col] == '1') {
                    dfs(row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width || g[row][col] != '1') return;

        // Mark the site as visited
        g[row][col] = '0';

        // Check all adjacent sites
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int result = numIslands(grid);
        System.out.println("Number of islands: " + result);
    }

    /* BFS solution

     public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
     */
}
