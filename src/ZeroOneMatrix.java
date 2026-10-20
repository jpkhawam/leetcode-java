/// https://leetcode.com/problems/01-matrix
void main() {
    int[][] testInput = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    int[][] expectedOutput = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};

    assert Arrays.deepEquals(updateMatrix(testInput), expectedOutput);
}

int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    // to avoid accidental overflow when adding + 1 to neighbors
    int INFINITY = m + n;

    int[][] dist = new int[m][n];

    // forward pass from top left to bottom right
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 0) {
                dist[i][j] = 0;
                continue;
            }

            int topValue = INFINITY;
            int leftValue = INFINITY;
            if (i > 0) {
                topValue = dist[i - 1][j];
            }
            if (j > 0) {
                leftValue = dist[i][j - 1];
            }

            dist[i][j] = 1 + Math.min(topValue, leftValue);
        }
    }

    // backwards pass from bottom right to top left
    for (int j = n - 1; j >= 0; j--) {
        for (int i = m - 1; i >= 0; i--) {
            if (dist[i][j] <= 1) {
                continue;
            }

            int bottomValue = INFINITY;
            int rightValue = INFINITY;
            if (i < m - 1) {
                bottomValue = dist[i + 1][j];
            }
            if (j < n - 1) {
                rightValue = dist[i][j + 1];
            }

            int minimumFromNeighbors = Math.min(bottomValue, rightValue);
            dist[i][j] = Math.min(dist[i][j], minimumFromNeighbors + 1);
        }
    }

    return dist;
}
