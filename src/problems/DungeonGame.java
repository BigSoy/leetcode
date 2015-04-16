package problems;

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0)
			return 0;
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] hp = new int[m][n];
		hp[m-1][n-1] = dungeon[m-1][n-1] < 0 ? (1 - dungeon[m-1][n-1]) : 1;
		for(int j=n-2; j>=0; j--)
			hp[m-1][j] = Math.max(1, hp[m-1][j+1] - dungeon[m-1][j]);
		for(int i=m-2; i>=0; i--)
			hp[i][n-1] = Math.max(1, hp[i+1][n-1] - dungeon[i][n-1]);
		for(int i=m-2; i>=0; i--)
			for(int j=n-2; j>=0; j--)
				hp[i][j] = Math.max(1, Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j]);
		return hp[0][0];
	}
	
	public static void main(String[] args) {
		int[][] dungeon = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
		System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
	}

}
