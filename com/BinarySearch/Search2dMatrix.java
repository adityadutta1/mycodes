class Solution {
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;

    int l = 0, r = matrix.length - 1;
///*** the mistake i did  ->answer lies in the value of r as l may crosss the target value as we increase l , while r will be decreasing so it will give us the lower bound for 
//that target value 
    // Finding the appropriate row
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (matrix[mid][0] <= target) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }

    // Now r is the last row that could contain the target
    int targetRow = r;
    if (targetRow < 0) return false; // No valid row

    // Binary search in the target row
    int lcol = 0, rcol = matrix[0].length - 1;
    while (lcol <= rcol) {
        int mid = lcol + (rcol - lcol) / 2;
        if (matrix[targetRow][mid] == target) {
            return true; // Found the target
        } else if (matrix[targetRow][mid] < target) {
            lcol = mid + 1; // Move right
        } else {
            rcol = mid - 1; // Move left
        }
    }

    return false; // Target not found in the matrix
}

}
