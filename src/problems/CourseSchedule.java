package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	private class Vertex {
		protected int inDegree;
		// List not Set, because there may be duplicated edges
		protected List<Integer> vertexNo;
		public Vertex() {
			inDegree = 0;
			vertexNo = new ArrayList<Integer>();
		}
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer> topoSeq = new ArrayList<Integer>();
		List<Vertex> adjacentList = new ArrayList<Vertex>(numCourses);
		for(int i=0; i<numCourses; i++)
			adjacentList.add(new Vertex());
		for(int[] edge : prerequisites) {
			adjacentList.get(edge[1]).vertexNo.add(edge[0]);
			adjacentList.get(edge[0]).inDegree++;
		}
		Queue<Integer> zeros = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++)
			if(adjacentList.get(i).inDegree == 0)
				zeros.add(i);
		while(!zeros.isEmpty()) {
			int n = zeros.poll();
			topoSeq.add(n);
			for(Integer v : adjacentList.get(n).vertexNo) {
				adjacentList.get(v).inDegree--;
				if(adjacentList.get(v).inDegree == 0)
					zeros.offer(v);
			}
		}
		return topoSeq.size() == numCourses;
	}

	public static void main(String[] args) {
		int numCourses = 10;
		int[][] prerequisites = { {5,8}, {3,5}, {1,9}, {4,5}, {0,2}, {1,9}, {7,8}, {4,9} };
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
	}
}
