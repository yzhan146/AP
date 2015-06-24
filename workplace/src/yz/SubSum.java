package leet;

public class Subsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsum s= new Subsum();
		int[] A = {1,2,3,4,5};
		System.out.println(s.isExist2(11,A) ==true ? "yes" : "no");
	}

	public boolean isExist(int s, int[] A) {
		if (A.length == 0) {
			return false;
		}
		int l = 0;
		int r = 0;
		int sum = A[0];
		//sliding window
		while (sum != s) {
			if (sum < s) {
				if (r < A.length - 1) {
					r++;
					sum += A[r];
				}
				else return false;
			} else {
				if (l <= r) {
					sum -= A[l];
					l++;
				} else {
					return false;
				}
			}
		}
		return true;
		
	}
	//DP
	public boolean isExist2(int s, int[] A) {
		if (A.length == 0) {
			return false;
		}
		int[][] dp = new int[A.length][A.length];
		dp[0][0] = A[0];
		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j < A.length; j++) {
				if (i == j) {
					dp[i][j] = A[i];
				} else {
					dp[i][j] = dp[i][j - 1] + A[j];
				}
				if (dp[i][j] == s) {
					return true;
				}
			}
		}
		return false;
	}
}
