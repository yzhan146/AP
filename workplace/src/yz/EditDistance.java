/*
 * @function: Edit Distance on leetcode, with extra output shows the details
 * @author: Yang Zhang
 * @date: 2015/6/21 -- EDT 12:19
 */

package leet;

import java.util.*;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		System.out.print(ed.calculate("2\nabcd acdb\naa aa"));
	}
	public String calculate(String input) {
		String[] inputs = input.split("\n");
		int n = Integer.parseInt(inputs[0]);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String[] cur = inputs[i].split(" ");
			List<String> answer = new ArrayList<String>();
			int steps = minDistance(cur[0], cur[1], answer);
			sb.append(n);
			sb.append("\n");
			if (answer.size() == 0) {
				sb.append(0);
				sb.append("\n");
				sb.append(0);
				sb.append("\n");
			}
			for (String inner : answer) {
				sb.append(inner);
				sb.append("\n");
			}
			sb.deleteCharAt(sb.length() - 1);
			if (i < n) {
				sb.append("\n\n");
			}
		}
		return sb.toString();
	}
	
	public int minDistance(String word1, String word2, List<String> result) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] map = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len2; i++) {
			map[0][i] = i;
		}
		for (int i = 1; i <= len1; i++) {
			map[i][0] = i;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j<= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					map[i][j] = map[i - 1][j - 1];
				} else {
					map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i][j- 1], map[i - 1][j])) + 1;
				}
			}
		}
		//above: key algorithm of DP
		//below: find the points we used to reach the final result
		int row = len1; 
		int col = len2;
		List<Cell> route = new ArrayList<Cell>();
		//result.add(word1);
		StringBuilder sb = new StringBuilder(word1);
		route.add(new Cell(row, col, map[len1][len2]));
		while (row > 0 || col > 0) {
			//back-tracking
			if (row > 0 && col >0) {
				int left = map[row][col - 1];
				int top = map[row - 1][col];
				int topLeft = map[row - 1][col - 1];
				int min = Math.min(left, Math.min(top, topLeft));
				if (topLeft == min) {
					row--;
					col--;
				} else if (left == min) {
					col--;
				} else {
					row--;
				}
			} else if (row == 0 && col > 0) {
				col--;
			} else if (row > 0 && col == 0) {
				row--;
			}
			route.add(0, new Cell(row, col, map[row][col]));
			//last one should be [0,0]
		}
		//now we have the route of the changing
		//next start recording the changes
		int place = 0;
		for (int i = 1; i < route.size(); i++) {
			Cell pre = route.get(i - 1);
			Cell cur = route.get(i);
			int prow = pre.row;
			int pcol = pre.col;
			int pval = pre.val;
			int crow = cur.row;
			int ccol = cur.col;
			int cval = cur.val;
			//fetch two cells from route and compare
			if (prow == crow) {
				sb.insert(place, word2.charAt(ccol - 1));
				place++;
			} else if (pcol == ccol) {
				sb.deleteCharAt(place);
			} else {
				//prow != crow && pcol != ccol;
				if (pval != cval) {
					sb.deleteCharAt(place);
					sb.insert(place, word2.charAt(ccol - 1));
				}
				place++;
			}
			if (!result.contains(sb.toString()) && !(sb.toString()).equals(word1)) {
				result.add(sb.toString());
			}
		}
		return map[len1][len2];
	}
	class Cell {
		int row;
		int col;
		int val;
		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
}
