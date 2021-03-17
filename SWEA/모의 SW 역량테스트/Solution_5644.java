import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_5644 {

	static class Battery{
		int r,c;
		int Cap,P;
		public Battery(int r, int c, int cap, int p) {
			super();
			this.r = r;
			this.c = c;
			Cap = cap;
			P = p;
		}
	}
	
	static int T,M,A;
	static int[] dc= {0,-1,0,1,0};
	static int[] dr= {0,0,1,0,-1};
	static int[][] map=new int[11][11];
	static Battery[] battery;
	static int[] userA,userB;
	static int tot;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			M=sc.nextInt();
			A=sc.nextInt();
			userA=new int[M];
			userB=new int[M];
			battery=new Battery[A];
			for (int i = 0; i < M; i++) {
				userA[i]=sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				userB[i]=sc.nextInt();
			}
			for (int i = 0; i < A; i++) {
				int r=sc.nextInt();
				int c=sc.nextInt();
				int Cap=sc.nextInt();
				int P=sc.nextInt();
				
				battery[i]=new Battery(r,c,Cap,P);
			}
			
			tot=0;
			int srA=1,scA=1;
			int srB=10,scB=10;
			move(srA,scA,srB,scB);
			for (int i = 0; i < M; i++) {
				int nrA=srA+dr[userA[i]];
				int ncA=scA+dc[userA[i]];
				int nrB=srB+dr[userB[i]];
				int ncB=scB+dc[userB[i]];
				move(nrA,ncA,nrB,ncB);
				srA=nrA;
				scA=ncA;
				srB=nrB;
				scB=ncB;
			}
			System.out.println("#"+t+" "+tot);
		}
	}
	
	static void move(int srA, int scA, int srB, int scB) {
		int max=0;
		ArrayList<Integer> listA=new ArrayList<>();
		ArrayList<Integer> listB=new ArrayList<>();
		
		for (int i = 0; i < A; i++) {
			
			int disA=Math.abs(battery[i].r-srA)+Math.abs(battery[i].c-scA);
			int disB=Math.abs(battery[i].r-srB)+Math.abs(battery[i].c-scB);

			if(disA<=battery[i].Cap) {
				listA.add(i);
			}
			if(disB<=battery[i].Cap) {
				listB.add(i);
			}
		}
		
		if(listA.size()==0&&listB.size()==0) return;
		else if(listA.size()==0) {
			for (int i = 0; i < listB.size(); i++) {
				max=Math.max(max,battery[listB.get(i)].P);
			}
		}
		else if(listB.size()==0) {
			for (int i = 0; i < listA.size(); i++) {
				max=Math.max(max,battery[listA.get(i)].P);
			}
		}
		else {
			for (int i = 0; i < listA.size(); i++) {
				int n1=listA.get(i);
				for (int j = 0; j < listB.size(); j++) {
					int n2=listB.get(j);
					if(n1==n2) {
						max=Math.max(max, battery[n1].P);
					}
					else {
						max=Math.max(max, battery[n1].P+battery[n2].P);
					}
				}
			}
		}
		
		tot+=max;
	}
	
}
