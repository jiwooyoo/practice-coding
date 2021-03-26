import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_14502 {

	static int N,M;
	static int[][] arr;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int[] p;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		ArrayList<int[]> list=new ArrayList<>();
		ArrayList<int[]> list2=new ArrayList<>();
		Queue<int[]> q=new LinkedList<>();
		Queue<int[]> q2=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==2) {
					q.offer(new int[] {i,j});
					list2.add(new int[] {i,j});
				}
				if(arr[i][j]==0) list.add(new int[] {i,j});
			}
		}
		q2.addAll(q);
		int len=list.size();
		p=new int[len];
		for (int i = 1; i <= 3; i++) {
			p[len-i]=1;
		}
		
		int min=Integer.MAX_VALUE;
		int cnt=0;
		do {
			cnt++;
			for (int i = 0; i < len; i++) {
				if(p[i]==1) {
					arr[list.get(i)[0]][list.get(i)[1]]=1;
				}
			}
			min=Math.min(min, bfs(q,list2));
			for (int i = 0; i < len; i++) {  //복구
				if(p[i]==1) {
					arr[list.get(i)[0]][list.get(i)[1]]=0;
				}
			}
			q.addAll(q2);
		}while(np(p.length-1));
		
		int res=q2.size()+list.size()-3-min;
		System.out.println(res);
	}
	
	private static boolean np(int size) {
		int i=size;
		while(i>0&&p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int tmp=p[i-1];
		p[i-1]=p[j];
		p[j]=tmp;
		int k=size;
		while(i<k) {
			tmp=p[i];
			p[i]=p[k];
			p[k]=tmp;
			i++;
			k--;
		}
		return true;
	}

	private static int bfs(Queue<int[]> q,ArrayList<int[]> al) {
		int cnt=0;
		boolean[][] visit=new boolean[N][M];
		for (int i = 0; i < al.size(); i++) {
			visit[al.get(i)[0]][al.get(i)[1]]=true;
		}
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			if(arr[r][c]!=1) {
			//	System.out.println(r+" "+c);
				cnt++;
			}

			for (int i = 0; i < 4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=M||visit[nr][nc]||arr[nr][nc]==1) continue;
				visit[nr][nc]=true;
				q.offer(new int[] {nr,nc});
			}
		}
		return cnt;
	}

}
