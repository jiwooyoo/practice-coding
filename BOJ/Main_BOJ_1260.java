import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260 {

	static class Graph{
		LinkedList<Integer> list=new LinkedList<>();
	}
	
	static int N,M,V;
	static Graph[] graph=new Graph[1001];
	static boolean[] v=new boolean[1001];
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s1=br.readLine().split(" ");
		N=Integer.parseInt(s1[0]);
		M=Integer.parseInt(s1[1]);
		V=Integer.parseInt(s1[2]);
		
		boolean[] check=new boolean[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			int st=Integer.parseInt(token.nextToken());
			int en=Integer.parseInt(token.nextToken());
			if(!check[st]) {
				check[st]=true;
				graph[st]=new Graph();
			}
			if(!check[en]) {
				check[en]=true;
				graph[en]=new Graph();
			}
			graph[st].list.add(en);
			graph[en].list.add(st);
		}
		
		for (int i = 1; i <= N; i++) {
			if(graph[i]==null) continue;
			Collections.sort(graph[i].list);
		}
		
		v[V]=true;
		sb.append(V+" ");
		dfs(V);
		System.out.println(sb);
		bfs();
		
	}
	private static void bfs() {
		boolean[] visit=new boolean[N+1];
		StringBuffer sbf=new StringBuffer();
		Queue<Integer> q=new LinkedList<>();
		visit[V]=true;
		q.offer(V);
		sbf.append(V+" ");
		
		while(!q.isEmpty()) {
			int current=q.poll();
			if(graph[current]==null) continue;
			for (int i = 0; i < graph[current].list.size(); i++) {
				int num=graph[current].list.get(i);
				if(visit[num]) continue;
				visit[num]=true;
				q.offer(num);
				sbf.append(num+" ");
			}
		}
		
		System.out.println(sbf);
	}
	
	static StringBuffer sb=new StringBuffer();
	private static void dfs(int start) {
		//System.out.println(start);
		if(graph[start]==null) {
			return;
		}
		
		for (int i = 0; i < graph[start].list.size(); i++) {
			int num=graph[start].list.get(i);
			if(v[num]) continue;
			v[num]=true;
			sb.append(num+" ");
			dfs(num);
		}
	}

}
