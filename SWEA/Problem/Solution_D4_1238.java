import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1238 {

	static class Graph{
		LinkedList<Integer> list;
		public Graph() {
			list=new LinkedList<>();
		}
	}
	
	static int N,start;
	static Graph[] graph;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N=sc.nextInt();
			start=sc.nextInt();
			graph=new Graph[101];
			boolean[] check=new boolean[101];
			for (int i = 0; i < N/2; i++) {
				int from=sc.nextInt();
				int go=sc.nextInt();
				if(!check[from]) graph[from]=new Graph();
				graph[from].list.add(go);
				check[from]=true;
			}
			
			System.out.println("#"+t+" "+bfs());
		}
	}
	
	static int bfs() {
		boolean[] visit=new boolean[101];
		Queue<int[]> q=new LinkedList<>();
		visit[start]=true;
		q.offer(new int[] {start,0});
		int max=start;
		int count=0;
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int current=temp[0];
			int cnt=temp[1];
			boolean check=false;
		//	System.out.println("current "+current);
	//		System.out.println("size "+graph[current].list.size());
			if(graph[current]==null) {
				//check=true;
				if(count<cnt) {
					count=cnt;
					max=current;
				}
				else if(cnt==count) {  
					if(max<current) max=current;
				}
				continue;
			}
			                          
			
			for (int i = 0; i < graph[current].list.size(); i++) {
				int next=graph[current].list.get(i);
				//System.out.print(next+" ");
				if(visit[next]) {
					if(count<cnt) {
						count=cnt;
						max=current;
					}
					else if(cnt==count) {  
						if(max<current) max=current;
					}
					continue;
				}
				visit[next]=true;
				q.offer(new int[] {next,cnt+1});
			}
			//System.out.println();
		}
		
		return max;
	}

}
