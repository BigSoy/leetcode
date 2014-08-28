package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		int n = intervals.size();
		if(n <= 1)
			return intervals;
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start)
					return -1;
				else if(o1.start > o2.start)
					return 1;
				else
					return 0;
			}
		});
		Interval prev = intervals.get(0);
		for(int i=1; i<n; i++) {
			Interval interval = intervals.get(i);
			if(interval.start > prev.end) {
				result.add(prev);
				prev = interval;
			} else {
				prev = new Interval(prev.start, Math.max(prev.end, interval.end));
			}
		}
		result.add(prev);
		return result;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(0,4));
		//intervals.add(new Interval(8,10));
		//intervals.add(new Interval(15,18));
		List<Interval> result = new MergeIntervals().merge(intervals);
		for(Interval i : result)
			System.out.println(i.start + " " + i.end);
	}
}
