package problems;

import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] pathSum = new int[n];
		pathSum[0] = triangle.get(0).get(0);
		for(int i=1; i<n; i++) {
			for(int j=i; j>=0; j--) {
				if(j == i)
					pathSum[j] = pathSum[j-1] + triangle.get(i).get(j);
				else if(j == 0)
					pathSum[j] += triangle.get(i).get(j);
				else
					pathSum[j] = Math.min(pathSum[j-1], pathSum[j]) + triangle.get(i).get(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int k=0; k<n; k++) {
			if(pathSum[k] < min)
				min = pathSum[k];
		}
		return min;
	}

}
