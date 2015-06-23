public int longestIncreasingSubsequence(int[] nums) {
	// write your code here
	if (nums.length == 0 || nums == null) {
		return 0;
	}
	int[] result = new int[nums.length];
	int max = 1;
	for (int i = 0; i < result.length; i++) {
		result[i] = 1;
	}
	for (int i = 1; i < nums.length; i++) {
		for (int j = 0; j < i; j++) {
			if (nums[i] >= nums[j]) {
				result[i] = Math.max(result[i], result[j] + 1);
			}
		}
		max = Math.max(max, result[i]);
	}
	return max;
}