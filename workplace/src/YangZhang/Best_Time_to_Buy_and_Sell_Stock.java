package leet;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock s = new Stock();
		String prices = "2\n1 3 5 7\n6 4";
		System.out.print(s.convert(prices));
	}
	public String maxProfit(int[] prices) {
		if (prices.length < 2) {
			return "0\n-1\n-1";
		}
		int[] profit = new int[prices.length];
		int max = 0;
		int maxIndex = 0;
		int minIndex = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			if (min == prices[i]) {
				minIndex = i;
			}
			profit[i] = prices[i] - min; //only different is here
			max = Math.max(profit[i], max);
		}
		if (max == 0) {
			return "0\n-1\n-1";
		}
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] == min + max) {
				maxIndex = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append("\n");
		sb.append(minIndex);
		sb.append(" ");
		sb.append(maxIndex);
		sb.append("\n");
		sb.append(prices[minIndex]);
		sb.append(" ");
		sb.append(prices[maxIndex]);
		return sb.toString();
	}
	//converter
	public String convert(String input) {
		if (input == null || input.length() == 0) {
			return "0\n-1\n-1";
		}
		String inputSplit[] = input.split("\n");
		int n = Integer.parseInt(inputSplit[0]);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String cur = inputSplit[i];
			String[] curSplit = cur.split(" ");
			int[] prices = new int[curSplit.length];
			for (int j = 0; j < prices.length; j++) {
				prices[j] = Integer.parseInt(curSplit[j]);
			}
			sb.append(maxProfit(prices));
			if (i != n) {
				sb.append("\n\n");
			}
		}
		return sb.toString();
	}
}



//DP
public int maxProfit(int[] prices) {
	if (prices.length < 2) {
		return 0;
	}
	int[] profit = new int[prices.length];
	int max = 0;
	int min = nums[0];
	for (int i = 1; i < prices.length; i++) {
		min = Math.min(min, prices[i]);
		profit[i] = prices[i] - min; //only different is here
		max = Math.max(profit[i], max);
	}
	return max;
}