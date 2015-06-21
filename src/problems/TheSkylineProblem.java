package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	
	private enum Type {
		LEFT, RIGHT
	}
	
	private class Point {
		int x;
		int y;
		Type type;
		Point(int x, int y, Type t) {
			this.x = x;
			this.y = y;
			this.type = t;
		}
	}
	
	// Comparator depends on how to deal with some boundary conditions.
	// It is important to sort all points correctly.
	private class PointComparator implements Comparator<Point> {
		@Override
		public int compare(Point P, Point Q) {
			if(P.x != Q.x)
				return P.x - Q.x;
			if(P.type != Q.type)
				return P.type == Type.LEFT ? -1 : 1;
			if(P.type == Type.LEFT && Q.type == Type.LEFT)
				return Q.y - P.y;
			if(P.type == Type.RIGHT && Q.type == Type.RIGHT)
				return P.y - Q.y;
			return 0;
		}
	}
	
	private class HeightComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<int[]>();
		List<Point> points = new ArrayList<Point>();
		for(int i=0; i<buildings.length; i++) {
			points.add(new Point(buildings[i][0], buildings[i][2], Type.LEFT));
			points.add(new Point(buildings[i][1], buildings[i][2], Type.RIGHT));
		}
		Collections.sort(points, new PointComparator());
		// max heap
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(11, new HeightComparator());
		int curHeight = 0;
		for(Point p : points) {
			if(p.type == Type.LEFT) {
				heap.offer(p.y);
				if(p.y > curHeight) {
					curHeight = p.y;
					int[] keyPoint = new int[2];
					keyPoint[0] = p.x;
					keyPoint[1] = p.y;
					result.add(keyPoint);
				}
			} else {
				heap.remove(p.y);
				Integer top = heap.peek();
				top = top == null ? 0 : top;
				if(p.y > top) {
					curHeight = top;
					int[] keyPoint = new int[2];
					keyPoint[0] = p.x;
					keyPoint[1] = top;
					result.add(keyPoint);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		int[][] buildings = { {0,2,3}, {2,5,3} };
		List<int[]> result = new TheSkylineProblem().getSkyline(buildings);
		for(int[] point : result)
			System.out.println(point[0] + " " + point[1]);
	}

}
