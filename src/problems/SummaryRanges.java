package problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length == 0)
			return result;
		int start = nums[0];
		int end = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == end + 1) {
				end++;
			} else {
				String r = start == end ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end);
				result.add(r);
				start = nums[i];
				end = nums[i];
			}
		}
		String r = start == end ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end);
		result.add(r);
		return result;
	}
}
