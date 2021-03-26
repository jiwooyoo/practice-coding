import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_9205 {

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int t,n;
	static int[][] map;
	public static void main(String[] args) {
		//다익스트라
		//편의점 : 1
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for (int T = 0; T < t; T++) {
			n=sc.nextInt();
			//길이 / 50 해줘야함
			map=new int[n+2][n+2];
			Node[] node=new Node[n+2];
			for (int i = 0; i < n+2; i++) {
				int r=sc.nextInt();
				int c=sc.nextInt();
				node[i]=new Node(r,c);
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < i; j++) {
					int dist=Math.abs(node[i].r-node[j].r)+Math.abs(node[i].c-node[j].c);
					map[i][j]=dist;
					map[j][i]=dist;
				}
			}
			
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					if(i==k) continue;
					for (int j = 0; j < n+2; j++) {
						if(j==k||j==i) continue;
						map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			Queue<Integer> q=new LinkedList<>();
			boolean[] visit=new boolean[n+2];
			q.offer(0);//시작점(상근이네 집)
			
			boolean check=false;
			while(!q.isEmpty()) {
				int num=q.poll();
				if(num==n+1) {
					check=true;
					break;
				}
				
				for (int i = 0; i < n+2; i++) {
					if(num!=i && !visit[i] && (double)map[num][i]/20<=50) {
						q.offer(i);
					}
				}
				
				visit[num]=true;
			}
			
			if(check) System.out.println("happy");
			else System.out.println("sad");
		}
	}

}
