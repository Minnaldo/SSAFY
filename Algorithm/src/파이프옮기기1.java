import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int[][] map;
	static int N;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		result = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(2,1,0);
		System.out.println(result);
	}
	static void move(int x, int y, int z) {
		if(x<1 || y<1 || x>N || y>N) return;
		if(map[y][x] == 1) return;
		if(x==N && y==N) {
			result++;
		}
		if(z == 0) {
			move(x+1, y, 0);
			if((x+1<=N)&&(y+1<=N)&&map[y+1][x]==0&&map[y][x+1]==0)
				move(x+1, y+1, 2);
		}
		else if(z == 1) {
			move(x, y+1, 1);
			if((x+1<=N)&&(y+1<=N)&&map[y+1][x]==0&&map[y][x+1]==0)
				move(x+1, y+1, 2);
		}
		else if(z == 2) {
			move(x+1, y, 0);
			move(x, y+1, 1);
			if((x+1<=N)&&(y+1<=N)&&map[y+1][x]==0&&map[y][x+1]==0)
				move(x+1, y+1, 2);
		}	
	}
}
