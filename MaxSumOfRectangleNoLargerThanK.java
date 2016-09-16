// This code is incompleted!!!

/* Given a non-empty 2D matrix martix and an integer k, find the max sum of a rectangle
 * in the matrix such that its sum is no larger than k.
 */
// Edge case: what if all the number is greater than the k. meaning the question is no solution.

public class MaxSumOfRectangleNoLargerThanK{
	
	public static void main(String[] args){
		int[][] matrix = {{1, 0, 1},{0, -2, 3}};
		int k = 2;
		System.out.println(maxSumSubmatrix(matrix, k));
	}

	public static int maxSumSubmatrix(int[][] matrix, int k){
		if(matrix == null)
			return 0;

		return maxSumSubmatrix(matrix, k, 0, matrix.length, 0, matrix[0].length);	
	}

	private static int maxSumSubmatrix(int[][] matrix, int k, int top, int bottom, int left, int right){
		// base case
		if(top == bottom && left == right){
			if(matrix[top][left] <= k)
				return matrix[top][left];
			else
				return Integer.MIN_VALUE;
		}

		int sumOfSubmatrix = sumSubmatrix(matrix, top, bottom, left, right);
		// Emma: Here is a problem

		// four cases: decrement one edge one time
		int topVal, bottomVal, leftVal, rightVal;
		topVal = bottomVal = leftVal = rightVal = Integer.MIN_VALUE;
		if(top != bottom){
			topVal = maxSumSubmatrix(matrix, k, top - 1, bottom, left, right);
			bottomVal = maxSumSubmatrix(matrix, k, top, bottom - 1, left, right);
		}

		if(left != right){
			leftVal = maxSumSubmatrix(matrix, k, top, bottom,left - 1, right);
			rightVal = maxSumSubmatrix(matrix, k, top, bottom,left, right - 1);
		}

		// find the largest val which is no greater than k
		return findClosestToKVal(k, topVal, bottomVal, leftVal, rightVal);

	}

	public static int sumSubmatrix(int[][] matrix, int top, int bottom, int left, int right){

		int sum = 0;
		for (int i = top; i <= bottom; i++) {
			for (int j = left; j <= right; j++) {
				sum+= matrix[i][j];
			}
		}
		return sum;
	}

	public static int findClosestToKVal(int k, int topVal, int bottomVal, int leftVal, int rightVal){

		int tmp = Integer.MIN_VALUE;
		if (k >= topVal) {
			tmp = Math.max(tmp, topVal);
		}
		if (k >= bottomVal) {
			tmp = Math.max(tmp, bottomVal);
		}
		if (k >= leftVal) {
			tmp = Math.max(tmp, leftVal);
		}
		if (k >= rightVal) {
			tmp = Math.max(tmp, rightVal);
		}
		return tmp;

	}
}
