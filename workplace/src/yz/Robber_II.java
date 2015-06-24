public int rob_loop(int nums[]) {
	//null check
	if (nums == null || nums.length == 0){
		return 0;
	}
	if (nums.length == 1){
		return nums[0];
	}
	if (nums.length == 2){
		return Math.max(nums[0], nums[1]);
	}
	//run the rob-method twice with different range
	return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
}
public int rob(int nums[], int start, int end) {
	int sum = Math.max(nums[start], nums[start + 1]);
	int pre = nums[start];

	for (int i = start + 2; i <= end; i++)
	{
		int temp = Math.max(sum, pre + nums[i]);
		pre = sum;
		sum = temp;
	}
	return sum;
}