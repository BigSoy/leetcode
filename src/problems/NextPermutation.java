package problems;

public class NextPermutation {

	private void reverse(int[] num, int l, int r) {
		while(l < r) {
			// swap
			num[l] ^= num[r];
			num[r] ^= num[l];
			num[l] ^= num[r];
			l++;
			r--;
		}
	}
	
	public void nextPermutation(int[] num) {
		if(num == null || num.length <= 1)
			return;
		int i = num.length - 2;
		while(i >= 0 && num[i] >= num[i+1])
			i--;
		if(i < 0)
			reverse(num, 0, num.length-1);
		else {
			int j = i + 1;
			while(j < num.length && num[j] > num[i])
				j++;
			j--;
			// swap
			num[i] ^= num[j];
			num[j] ^= num[i];
			num[i] ^= num[j];
			reverse(num, i+1, num.length-1);
		}
	}
	
	public static void main(String[] args) {
		int[] num = {2,3,1};
		new NextPermutation().nextPermutation(num);
		for(int i : num)
			System.out.print(i + " ");
	}
}
