import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_13913 {
	static int N,K;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
			
			Queue<Integer> q=new LinkedList<>();
			q.offer(N);
			int[] visit=new int[100001];
			Arrays.fill(visit, -1);
			int[] cnt=new int[100001];
			cnt[N]=1;
			visit[N]=N;
			int next;
			
			while(!q.isEmpty()) {
				int now=q.poll();
				
				if(now==K) {
					System.out.println(cnt[now]-1);
					StringBuilder sb=new StringBuilder();

					Stack<Integer> st=new Stack<>();
					while(visit[now]!=now) {
						st.push(now);
						now=visit[now];
					}
					st.push(now);
					while(!st.isEmpty()) {
						sb.append(st.pop()+" ");
					}
					System.out.println(sb);
					break;
				}
				
				next=now+1;
				if(next<=100000 && visit[next]==-1) {
					visit[next]=now;
					cnt[next]=cnt[now]+1;
					q.offer(next);
				}
				next=now-1;
				if(next>=0&& visit[next]==-1) {
					visit[next]=now;
					cnt[next]=cnt[now]+1;
					q.offer(next);
				}
				next=now*2;
				if(next<=100000 && visit[next]==-1) {
					visit[next]=now;
					cnt[next]=cnt[now]+1;
					q.offer(next);
				}
				
				
			}
		
	}

}
