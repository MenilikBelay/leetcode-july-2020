package com.tedemach.july7;

class FastSolution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null)
            return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                perimeter += (i == grid.length - 1 || grid[i + 1][j] == 0 ? 1 : 0);
                perimeter += (i == 0 || grid[i - 1][j] == 0 ? 1 : 0);
                perimeter += (j == grid[i].length - 1 || grid[i][j + 1] == 0 ? 1 : 0);
                perimeter += (j == 0 || grid[i][j - 1] == 0 ? 1 : 0);
            }
        }
        return perimeter;
    }
}
