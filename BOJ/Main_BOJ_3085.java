import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_3085 {

	static int N;
	static char[][] candy,arr;
	static int tot1=1,tot2=1,max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		candy=new char[N+1][N+1];
		arr=new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		max=0;
		//행끼리 바꾸는 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N) {
					char temp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = temp;
					count();
					temp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = temp;
				}
				if (i + 1 < N) {
					char temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
					count();
					temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
				}
			}
		}
		
		System.out.println(max);
	}

	public static void count() {
		
		for (int i = 0; i < N; i++) {
			int cnt=1;
			for (int j = 1; j < N; j++) {
				if(arr[i][j-1]==arr[i][j]) {
					cnt++;
				}
				else {
					cnt=1;
				}
				if(max<cnt) max=cnt;
					
			}
			cnt=1;
			for (int j = 1; j < N; j++) {
				
					if(arr[j-1][i]==arr[j][i]) {
						cnt++;
					}
					else {
						cnt=1;
					}
					if(max<cnt) max=cnt;
			}
		}
		
	}
	

}
