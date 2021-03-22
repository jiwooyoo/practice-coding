import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1753 {

	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	static int V,E,K;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine().trim());
		arr=new int[V+1];
		visit=new boolean[V+1];
		
		ArrayList<Node>[] node=new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			node[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			
			node[start].add(new Node(end,weight));
		}
		
		PriorityQueue<Node> pq=new PriorityQueue<>();
		int current=K;
		Arrays.fill(arr, Integer.MAX_VALUE);
		pq.offer(new Node(K,0));
		arr[K]=0;
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			current=n.end;
			int weight=n.weight;
			
			if(visit[current])continue;
			visit[current]=true;
			
			for(Node nn: node[current]) {
				if(arr[nn.end]>arr[current]+nn.weight) {
					arr[nn.end]=arr[current]+nn.weight;
					pq.offer(new Node(nn.end,arr[nn.end]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(arr[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(arr[i]);
		}
	}

}
