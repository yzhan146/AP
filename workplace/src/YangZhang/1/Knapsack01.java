class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	}

	public int find(int sizes, int items, int[] size, int[] value) {
		if (info.length == 0 || info == null || size == 0 || items == 0) {
			return 0;
		}
		int[][] dp = new int[1 + items][1 + sizes];
		for (int i = 0; i <= items; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= sizes; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= items; i++) {
			for (int j = 1; j <= sizes; j++) {
				if (j >= size[i]) {
					dp[i][j] = Math.max(dp[i - 1][j - size[i]] + value[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[items][sizes];
	}
}