package problems;

public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int s = (C - A) * (D - B) + (G - E) * (H - F);
		int l_max = Math.max(A, E);
		int r_min = Math.min(C, G);
		int u_min = Math.min(D, H);
		int d_max = Math.max(B, F);
		if(l_max >= r_min || u_min <= d_max)
			return s;
		return s - (r_min - l_max) * (u_min - d_max);
	}
}
