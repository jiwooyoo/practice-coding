import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_BOJ_1707 {

	static int K,V,E;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < K; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			p=new int[V+1];
			
			ArrayList<Integer> list[]=new ArrayList[V+1];
			for (int i = 0; i < V+1; i++) {
				list[i]=new ArrayList<Integer>();
			}
			
			int start=0,end=0;
			for (int i = 0; i < E; i++) {
				st=new StringTokenizer(br.readLine());
				start=Integer.parseInt(st.nextToken());
				end=Integer.parseInt(st.nextToken());
				list[start].add(end);   // 무방향 그래프  
				list[end].add(start);
			}
			
			Queue<Integer> q=new LinkedList<>();
			boolean check=true;
			for (int i = 1; i <= V; i++) {   //혹시 아예 1과 연결 안되어있는노드가 있을 경우를 대비하여 전체 노드 탐색  
				if(p[i]!=0) continue;
				q.offer(i);    // 현재 노드 넣기 
				p[i]=1;  // 방문 표시 
				
				while(!q.isEmpty() && check) {
					int current=q.poll();
					for (int j = 0; j < list[current].size(); j++) {
						int index=list[current].get(j);
						if(p[index]==0) {  //아직  방문X
							q.offer(index);
							p[index]=p[current]*(-1);
						} else if(p[index]==p[current]) {   // 나랑 같은 집합인데 현재 연결되어있
							check=false;   // 바로 실패!! 
							break;
						}
					}
				}
			}
			
			if(check) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
