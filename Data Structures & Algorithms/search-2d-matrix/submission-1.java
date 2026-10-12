class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lo = 0;
        int hi = rows * cols - 1;
        
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int row = mid / cols;
            int col = mid % cols;

            System.out.println(matrix[row][col]);

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
        
    }
}
