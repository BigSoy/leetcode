package problems;

public class MaxPointsOnALine {

	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public int maxPoints(Point[] points) {
		if(points == null)
			return 0;
		if(points.length < 3)
			return points.length;
		
		int maxNum = 2;
		for(int i=0; i<points.length-1; i++) {
			// record the number of duplicated points before points[j]
			int duplicated = 0;
			for(int j=i+1; j<points.length; j++) {
				// record the number of points in current line
				int num = 1;
				if(points[i].x == points[j].x) {
					if(points[i].y == points[j].y) {
						duplicated++;
						num += duplicated;
					} else {
						num += duplicated + 1;
						for(int k=j+1; k<points.length; k++)
							if(points[k].x == points[i].x)
								num++;
					}
				} else {
					num += duplicated + 1;
					double slope = ((double)(points[j].y - points[i].y)) / (points[j].x - points[i].x);
					for(int k=j+1; k<points.length; k++) {
						if(points[k].x == points[i].x && points[k].y == points[i].y) {
							num++;
						} else {
							double new_slope = ((double)(points[k].y - points[i].y)) / (points[k].x - points[i].x);
							if(slope == new_slope)
								num++;
						}
					}
				}
				maxNum = Math.max(maxNum, num);
			}
		}
		return maxNum;
	}
	
	public static void main(String[] args) {
		Point[] points = {new Point(1,1), new Point(1,1), new Point(1,1)};
		int result = new MaxPointsOnALine().maxPoints(points);
		System.out.println(result);
	}
}
