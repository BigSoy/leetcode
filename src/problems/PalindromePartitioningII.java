package problems;

/**
 * Reference : http://blog.csdn.net/u011095253/article/details/9177451
 * @author ls
 *
 */
public class PalindromePartitioningII {

	private boolean[][] makeTable(String s) {
		char[] chArr = s.toCharArray();
		int len = chArr.length;
		boolean[][] dpMat = new boolean[len][len];
		for(int i=0; i<len; i++)
			dpMat[i][i] = true;
		for(int i=1; i<len; i++) {
			//even
			int l = i-1;
			int r = i;
			while(l >= 0 && r < len && chArr[l] == chArr[r])
				dpMat[l--][r++] = true;
			//odd
			l = i - 1;
			r = i + 1;
			while(l >= 0 && r < len && chArr[l] == chArr[r])
				dpMat[l--][r++] = true;
		}
		return dpMat;
	}
	
	public int minCut(String s) {
		boolean[][] table = makeTable(s);
		int len = s.length();
		int[] cuts = new int[len+1];
		cuts[len] = -1;
		for(int i=len-1; i>=0; i--) {
			cuts[i] = len - i - 1;
			for(int j=i; j<len; j++) {
				if(table[i][j]) {
					cuts[i] = Math.min(cuts[i], 1 + cuts[j+1]);
				}
			}
		}
		return cuts[0];
	}
	
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(new PalindromePartitioningII().minCut(s));
	}
}
