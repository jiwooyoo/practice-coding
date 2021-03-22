package jungol;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_JO_1681 {
	
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int res;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N][N];
		visit=new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		res=Integer.MAX_VALUE;
		visit[0]=true;
		getWay(0,0);
		System.out.println(res);
	}
	
	static void getWay(int start,int sum) {
		for (int i = 1; i < N; i++) {
			if(visit[i]||arr[start][i]==0) continue;
			
			if(sum+arr[start][i]>res) continue;
			visit[i]=true;
			getWay(i,sum+arr[start][i]);
			visit[i]=false;
		}
		
		boolean check=false;
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				check=true; //방문 안한곳이 하나라도 있다면
				break; //0으로 출력
			}
		}
		
		if(!check && arr[start][0]!=0) {
			res=Math.min(res, sum+arr[start][0]);
		}
	}

}
