import java.util.Scanner;

public class QualityMeasurementApp2 {
    static int m, n;
    static int[][] grid;
    static boolean[][] visited;

    // DFS function
    static void dfs(int row, int col) {

        // Check boundaries
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }

        // If water or already visited
        if (grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        // Mark visited
        visited[row][col] = true;

        // Move in 4 directions
        dfs(row + 1, col); // down
        dfs(row - 1, col); // up
        dfs(row, col + 1); // right
        dfs(row, col - 1); // left
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        grid = new int[m][n];
        visited = new boolean[m][n];

        // Input grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int islands = 0;

        // Traverse grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(islands);
    }

}
