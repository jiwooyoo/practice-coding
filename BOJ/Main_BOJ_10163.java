import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10163 {

	static int N;
	static int[][] paper;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		paper=new int[101][101];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken());
			int c1=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			
			color(r1,c1,w,h,i);
		}
		
		int[] cnt=new int[101];
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(paper[i][j]==0) continue;
				cnt[paper[i][j]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(cnt[i]);
		}
	}
	private static void color(int r1, int c1, int w, int h,int num) {
		for (int i = r1; i < r1+w; i++) {
			for (int j = c1; j < c1+h; j++) {
				paper[i][j]=num;
			}
		}
	}

}
