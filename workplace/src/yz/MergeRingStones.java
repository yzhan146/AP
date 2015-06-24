/*
 * @function: count the points of merging stones
 * @author: Yang Zhang
 * @date: 2015/6/21
 */

package leet;
import java.util.*;
public class MergeStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeStone ms = new MergeStone();
		int[] stones = {5,2,3,6,7};
		System.out.println(ms.merge(stones));
	}
	public List<List<Integer>> merge(int[] stones) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//null case
		if (stones.length == 0 || stones == null) {
			return result;
		}
		//1 case
		if (stones.length == 1) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(stones[0]);
			result.add(temp);
			return result;
		}
		//normal cases
		List<Integer> stone =  new ArrayList<Integer>();
		//copy input into list
		for (int i = 0; i < stones.length; i++) {
			stone.add(stones[i]);
		}
		result.add(new ArrayList<Integer>(stone));
		//algorithm start
		int index = 0;
		int max = 0;
		while (stone.size() > 2) {
			//add the first element to the tail of the sequence
			stone.add(stone.get(0));
			for (int i = 1; i < stone.size(); i++) {
				if (stone.get(i) + stone.get(i - 1) > max) {
					index = i;
					max = stone.get(i) + stone.get(i - 1);
				}
			}
			if (index == stone.size() - 1) {
				//loop
				stone.remove(stone.size() - 1);
				stone.remove(stone.size() - 1);
				stone.remove(0);
				stone.add(0, max);
			} else {
				stone.remove(index - 1);
				stone.remove(index - 1);
				stone.remove(stone.size() - 1);
				stone.add(index - 1, max);
			}
			result.add(new ArrayList<Integer>(stone));
		}
		//add the last one
		int last = stone.get(0) + stone.get(1);
		stone.clear();
		stone.add(last);
		result.add(new ArrayList<Integer>(stone));
		return result;
	}
}
