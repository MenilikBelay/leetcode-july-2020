package com.tedemach.july7;

class SlowSolution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int perimeter = getOuterPerimeter(grid, i, j);
                if (perimeter > 0)
                    return perimeter; // assuming only one island
            }
        }
        return 0;
    }

    private int getOuterPerimeter(int[][] grid, int row, int col) {
        // base cases
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        } else if (grid[row][col] == -1) {
            return -1;
        }
        // end of base case
        grid[row][col] = -1;
        int perimeter = 0;
        int temp = getOuterPerimeter(grid, row + 1, col);
        perimeter += temp > 0 ? temp : temp + 1;
        temp = getOuterPerimeter(grid, row - 1, col);
        perimeter += temp > 0 ? temp : temp + 1;
        temp = getOuterPerimeter(grid, row, col - 1);
        perimeter += temp > 0 ? temp : temp + 1;
        temp = getOuterPerimeter(grid, row, col + 1);
        perimeter += temp > 0 ? temp : temp + 1;
        return perimeter == 0 ? -1 : perimeter;
    }
}

/*
 * // assuming I can side-effect the given array (change the value of grid) [if
 * not, copy to another array]
 * 
 * int getOuterPerimeter (int[][] grid, int row, int col) { // base cases if
 * (row >= grid.length || col >= grid[row].length || row < 0 || col < 0 ||
 * grid[row][col] == 0) { return 0; } else if (grid[row][col] == -1) { return
 * -1; } // end of base case grid[row, col] = -1; int perimeter =
 * getOuterPerimeter(grid, row + 1, col) + 1; perimeter +=
 * getOuterPerimeter(grid, row - 1, col) + 1; perimeter +=
 * getOuterPerimeter(grid, row, col - 1) + 1; perimeter +=
 * getOuterPerimeter(grid, row, col + 1) + 1; return perimeter; }
 * 
 * // test [[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]
 * 
 */
