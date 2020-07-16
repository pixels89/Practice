package in.barmans.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	};

	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		LinkedList<Interval> mergedIntervals = new LinkedList<Interval>();
		Deque<Interval> stack = mergedIntervals;
		stack.push(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {
			Interval intv = stack.peek();
			if (intv.end > intervals.get(i).start) {
				intv.end = Math.max(intv.end, intervals.get(i).end);
			} else
				stack.push(intervals.get(i));
		}
		return mergedIntervals;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
