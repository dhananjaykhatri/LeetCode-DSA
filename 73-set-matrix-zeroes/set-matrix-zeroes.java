class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        for (int i : l1) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : l2) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}