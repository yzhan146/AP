package leet;
import java.util.*;
public class MaxSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSquare ms = new MaxSquare();
		String input = "2\n2 2\n1 1 1 1\n4 5\n1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0";
		System.out.print(ms.solve(input));
	}

	public int maximalSquare(char[][] matrix, List<Integer> result) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }      
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] map = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            map[i][0] = matrix[i][0] - '0';
            max = Math.max(max, map[i][0]);
        }
        for (int i =0; i < n; i++) {
            map[0][i] = matrix[0][i] - '0';
            max = Math.max(max, map[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                }
                max = Math.max(map[i][j], max);
            }
        }
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == max) {
					int startrow = i - max + 1;
					int startcol = j - max + 1;
					result.add(startrow);
					result.add(startcol);
					result.add(startrow);
					result.add(j);
					result.add(i);
					result.add(startcol);
					result.add(i);
					result.add(j);
					return max * max;
				}
			}
		}
        return max * max;
    }
	//output converter
	public String output(char[][] map) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n = maximalSquare(map, result);
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		sb.append("\n");
		for (Integer in : result) {
			sb.append(in);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	//input translator
	public String solve(String input) {
		String[] inputs = input.split("\n");
		int n = Integer.parseInt(inputs[0]);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < inputs.length; i = i + 2) {
			String[] mn = inputs[i].split(" ");
			int mn0 = Integer.parseInt(mn[0]);
			int mn1 = Integer.parseInt(mn[1]);
			String[] info = inputs[i + 1].split(" ");
			char[][] map = new char[mn0][mn1];
			for (int j = 0; j < mn0; j++) {
				for (int k = 0; k < mn1; k++) {
					map[j][k] = info[j * mn1 + k].charAt(0);
				}
			}
			sb.append(output(map));
			if (i != inputs.length - 2) {
				sb.append("\n\n");
			}
		}
		return sb.toString();
	}
}
