class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int middle;

        int row = 0;

        while (left <= right) {
            middle = (right + left) / 2;

            if (matrix[right][0] <= target && (right == m - 1 || matrix[right + 1][0] > target)) {
                row = right;
                break;
            }

            if (matrix[middle][0] <= target && (middle == m - 1 || matrix[middle + 1][0] > target)) {
                row = middle;
                break;
            }

            if (matrix[left][0] <= target && (left == m - 1 || matrix[left + 1][0] > target)) {
                row = left;
                break;
            }

            if (matrix[middle][0] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        left = 0;
        right = n - 1;

        while (left <= right) {
            middle = (right + left) / 2;

            if (matrix[row][right] == target) {
                return true;
            }

            if (matrix[row][middle] == target) {
                return true;
            }

            if (matrix[row][left] == target) {
                return true;
            }

            if (matrix[row][middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
