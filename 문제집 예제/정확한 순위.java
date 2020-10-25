import java.util.*;
import java.util.Scanner;
import java.io.*;


public class Main {
	public static int[][] arr=new int[501][501];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n,m;
		int INF=(int)1e9;
		
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		for(int i=0;i<501;i++) {
			Arrays.fill(arr[i], INF);
		}
		for(int i=1;i<=n;i++) {
			arr[i][i]=0;
		}
		
		for(int i=0;i<m;i++) {
			int a,b;
			a=sc.nextInt();
			b=sc.nextInt();
			arr[a][b]=1;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int res=0;
		for(int i=1;i<=n;i++) {
			int cnt=0;
			for(int j=1;j<=n;j++) {
				if(arr[i][j]!=INF||arr[j][i]!=INF) {
					cnt++;
				}
			}
			
			if(cnt==n) {
				res++;
			}
		}
		
		System.out.println(res);
	}
}
