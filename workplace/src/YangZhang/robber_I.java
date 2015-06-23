public int robber (int nums[]) {
	//null check
	if (nums.length == 0 || nums == null) {
		return 0;
	}
	//initial case
	if (nums.length == 1) {
		return nums[0];
	}
	if (nums.length == 2) {
		return Math.max(nums[0], nums[1]);
	}

	//DP
	int sum = Math.max(nums[0], nums[1]);
	int pre = nums[0];
	for (int i = 2; i < nums.length; i++) {
		//move the first pointer one step ahead first
		int temp = Math.max(nums[i] + pre, sum);
		//move the second pointer one step ahead next,
		//so as to ensure gap between pointers always exist
		pre = sum;
		sum = temp;
	}
	return sum;
}





//DP solution
package leet;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String input = "2\n1 2\n1 2 3 4 5 1 2 3 4 5";
		System.out.println(s.convert(input));
	}
	
	public String rob(int[] num) {
/*		if(num.length==0) return "0";
		if(num.length==1) return num[0];
		if(num.length==2) return Math.max(num[0],num[1]);*/

		int[] dp = new int[num.length];
		dp[0] = num[0];
		dp[1] = Math.max(num[0], num[1]);
		for (int i = 2; i < num.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
		}
		int result = dp[num.length - 1];
		StringBuilder sbPos = new StringBuilder();
		StringBuilder sbNum = new StringBuilder();
		for (int i = num.length - 1; i >= 0; i--) {
			if (i > 0 && dp[i] == dp[i - 1]) {
				continue;
			}
			if (result == dp[i]) {
				sbPos.insert(0, i);
				sbPos.insert(0, " ");
				sbNum.insert(0, num[i]);
				sbNum.insert(0, " ");
				result -= num[i];
			}
		}
		sbPos.deleteCharAt(0);
		sbNum.deleteCharAt(0);
		sbPos.insert(0, "\n");
		sbPos.insert(0, dp[num.length - 1]);
		sbPos.append("\n");
		sbPos.append(sbNum.toString());
		//print
		return sbPos.toString();
	}



	//API
	public String rob(int n, String[] input) {
	//where n refers to the length of String array "input"
		if (n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String cur = input[i];
			String[] curNum = cur.split(" ");

			int[] num = new int[curNum.length];
			for (int j = 0; j < num.length; j++) {
				num[j] = Integer.parseInt(curNum[j]);
			}

			sb.append(rob(num));
			if (i < n) {
				//it's not working
				sb.append("\n\n");
			}
		}
		return sb.toString();
	}

	//Converter
	public String convert(String input) {
		if (input == null || input.equals("")) {
			return input;
		}

		String[] convert = input.split("\n");
		int n = Integer.parseInt(convert[0]);
		return rob(n, convert);
	}
}
