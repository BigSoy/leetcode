package problems;

import java.util.ArrayList;

public class InsertInterval {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> ret = new ArrayList<Interval>();
		int size = intervals.size();
		if(size == 0) {
			ret.add(newInterval);
			return ret;
		}
		int mergeStart = -1, mergeEnd = -1;
		for(int i=0; i<size; i++) {
			Interval interval = intervals.get(i);
			if(-1 == mergeStart) {
				if(newInterval.start > interval.end) {
					ret.add(interval);
					continue;
				}
				mergeStart = Math.min(interval.start, newInterval.start);
				if(newInterval.end < interval.start) {
					mergeEnd = newInterval.end;
					ret.add(newInterval);
					ret.add(interval);
				} else if(newInterval.end <= interval.end) {
					mergeEnd = interval.end;
					ret.add(new Interval(mergeStart, mergeEnd));
				}
			} else if(-1 == mergeEnd) {
				if(newInterval.end > interval.end)
					continue;
				if(newInterval.end < interval.start) {
					mergeEnd = newInterval.end;
					ret.add(new Interval(mergeStart, mergeEnd));
					ret.add(interval);
				} else {
					mergeEnd = interval.end;
					ret.add(new Interval(mergeStart, mergeEnd));
				}
			} else {
				ret.add(interval);
			}
		}
		if(-1 == mergeStart) {
			ret.add(newInterval);
		} else if(-1 == mergeEnd) {
			ret.add(new Interval(mergeStart, newInterval.end));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		Interval newInterval = new Interval(4,9);
		ArrayList<Interval> ret = new InsertInterval().insert(intervals, newInterval);
		for(int i=0; i<ret.size(); i++)
			System.out.println(ret.get(i).start + " " + ret.get(i).end);
	}
}
