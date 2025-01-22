import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        // Result matrix to store heights
        int[][] heights = new int[rows][cols];

        // Visited matrix to track processed cells
        boolean[][] visited = new boolean[rows][cols];

        // Queue for BFS
        Queue<Cell> queue = new LinkedList<>();

        // Initialize the queue with all water cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col] == 1) {
                    queue.add(new Cell(row, col, 0)); // Add water cell with height 0
                    heights[row][col] = 0; // Water cells have height 0
                    visited[row][col] = true; // Mark as visited
                } else {
                    heights[row][col] = -1; // Placeholder for land cells
                }
            }
        }

        // Direction vectors for moving up, down, left, right
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // Perform BFS
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row;
            int col = current.col;
            int height = current.height;

            // Traverse all 4 neighboring cells
            for (int direction = 0; direction < 4; direction++) {
                int newRow = row + deltaRow[direction];
                int newCol = col + deltaCol[direction];

                // Check if the neighbor is within bounds and unvisited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    heights[newRow][newCol] = height + 1; // Update height
                    queue.add(new Cell(newRow, newCol, height + 1)); // Add to queue
                    visited[newRow][newCol] = true; // Mark as visited
                }
            }
        }

        return heights;
    }
}

// Custom Cell class to store row, column, and height
class Cell {
    int row, col, height;

    Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}