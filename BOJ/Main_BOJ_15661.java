import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_15661 {
	static int N;
	static int[][] arr;
	static boolean[] team;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N][N];
		team=new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		power(0);
		
		System.out.println(min);
		
	}
	
	public static void power(int cnt) {
		if(cnt==N) {
			int start=0;
			int link=0;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if(team[i]!=team[j]) continue;
					if(team[i]==true) {
						start+=(arr[i][j]+arr[j][i]);
					}
					else {
						link+=(arr[i][j]+arr[j][i]);
					}
				}
			}
			min=Math.min(min, Math.abs(start-link));
			return;
		}
		
			team[cnt]=true;
			power(cnt+1);
			team[cnt]=false;
			power(cnt+1);
		
	}

}
