import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1197 {   //prim으로 풀어보기!!!

	static class Node{
		int start;
		int end;
		int weight;
		public Node(int start,int end, int weight) {
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}
	static int V,E;
	static ArrayList<int[]> list[];
	static long res;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i]=new ArrayList<int[]>();
		}
		
		int A,B,C;
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			list[A].add(new int[] {B,C});
			list[B].add(new int[] {A,C});
		}
		
		prim(1);
		System.out.println(res);
	}
	
	private static void prim(int start) {
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		pq.add(new int[] {start,0});
		int count=0;
		boolean[] visit=new boolean[V+1];
		while(!pq.isEmpty()) {
			int[] temp=pq.poll();
			if(visit[temp[0]]) continue;
			visit[temp[0]]=true;
			
			res+=temp[1];
			for(int[] arr:list[temp[0]]) {
				if(!visit[arr[0]]) {
					pq.add(arr);
				}
			}
			count++;
			if(count==V) break;
		}
	}

}
