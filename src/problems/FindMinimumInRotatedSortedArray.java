package problems;

public class FindMinimumInRotatedSortedArray {

	private int binaryFind(int[] num, int l, int r) {
		if(l == r)
			return num[l];
		if(num[l] < num[r])
			return num[l];
		int mid = (l+r)/2;
		return Math.min(binaryFind(num, l, mid), binaryFind(num, mid+1, r));
	}
	
	public int findMin(int[] num) {
		if(num == null || num.length == 0)
			return -1;
		return binaryFind(num, 0, num.length-1);
	}
	
	public static void main(String[] args) {
		int [] num = {4, 5, 6, 7, 0, 1, 2};
		int min = new FindMinimumInRotatedSortedArray().findMin(num);
		System.out.println(min);
	}
}
