import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_20304 {
	static int N,M;
	static Queue<Password> candi=new LinkedList<>();
	static boolean[] v;
	static class Password{
		int num;
		int cnt;
		public Password(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());  //패스워드의 최댓값
		int M=Integer.parseInt(br.readLine());  //사용 패스워드 개수
		
		int[] p=new int[M];  //해커들이 입력한 번호들
		v=new boolean[N+1];
		int max=0;
		
		String[] s=br.readLine().trim().split(" ");  //입력 한 줄에 받아서 나누기
		
		for (int i = 0; i < M; i++) {
			p[i]=Integer.parseInt(s[i]); 
			candi.offer(new Password(p[i],0));
		}
		
		while(!candi.isEmpty()) {
			Password pw=candi.poll();
			for (int i = 1; i <= N; i<<=1) {
				int n;
				if((pw.num&i)>0) {  //같다는 것
				//	v[pw.num]=false;
					n=pw.num-i;
					/*if(n>=0&&n<=N&&!v[pw.num]) {
						v[pw.num]=true;
						//pw.cnt+=1;
						candi.offer(new Password(n,pw.cnt+1));
					}*/
				}
				else {  //다르다는 것
					n=pw.num+i;
				/*	if(n<=N&&!v[n]) {
						v[n]=true;
						candi.offer(new Password(n,pw.cnt+1));
						max=Math.max(max, pw.cnt+1);
					} */
				}
				
				if(n<=N&&!v[n]) {
					v[n]=true;
					candi.offer(new Password(n,pw.cnt+1));
					max=Math.max(max, pw.cnt+1);
				}
			}
		}
		
		System.out.println(max);
		
	}


}
