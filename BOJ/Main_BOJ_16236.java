import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_16236 {

	static int N;
	static int[][] shark;
	static int[] dr= {-1,0,0,1};
	static int[] dc= {0,-1,1,0};
	static int r,c;
	static int time,num,cnt,size=2;
	static boolean stop=false;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		shark=new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				shark[i][j]=sc.nextInt();
				if(shark[i][j]==9) {
					r=i;
					c=j;
				}
				else if(shark[i][j]!=0) {
					num++;
				}
			}
		}
		
	//	int n=0;
		while(num!=0) {
			bfs();
		//	n++;
			if(stop) break;
		}
		
		System.out.println(time);
		
	}
	
	private static void bfs() {
		
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c,0});
		boolean[][] v=new boolean[N][N];
		v[r][c]=true;
		shark[r][c]=0;
		boolean check=false;
	//	System.out.println(r+" "+c+" "+time);
		
		ArrayList<int[]> list=new ArrayList<>();
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int cr=temp[0];
			int cc=temp[1];
			int t=temp[2];
			
			for (int i = 0; i < 4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=N||v[nr][nc]||shark[nr][nc]>size) continue;
				if(shark[nr][nc]!=0 && shark[nr][nc]<size) { //상어가 있다는 것
				//	System.out.println("*"+nr+" "+nc);
					list.add(new int[] {nr,nc,t+1});
					check=true;
				}
				
				v[nr][nc]=true;
				q.offer(new int[] {nr,nc,t+1});
			}
			
			//if(check) break;
		}
		
		if(check) {
			int min=Integer.MAX_VALUE;
			int mr=0,mc=0;
			for (int i = 0; i < list.size(); i++) {
				if(min>list.get(i)[2]) {
					min=list.get(i)[2];
					mr=list.get(i)[0];
					mc=list.get(i)[1];
				}
				else if(min==list.get(i)[2]) {
			//		System.out.println("***");
					if(mr>list.get(i)[0]) {
						mr=list.get(i)[0];
						mc=list.get(i)[1];
					}else if(mr==list.get(i)[0]) {
						if(mc>list.get(i)[1]) {
							mc=list.get(i)[1];
						}
					}
				}
			}
			
			cnt++;
			shark[r][c]=0;
			shark[mr][mc]=0;
			r=mr;
			c=mc;
			num--;
			time+=min;
		}
		else {
			stop=true;
		}
		
		if(cnt==size) {
			size++;
			cnt=0;
		}
		
	}

}
