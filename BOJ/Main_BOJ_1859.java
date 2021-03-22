import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1859 {

	static class Score implements Comparable<Score> {
		int T;
		int P;
		double percent;
		public Score(int T,int P) {
			this.T=T;
			this.P=P;
			this.percent=(double)T/P;
		}
		
		public Score(int T,int P,double percent) {
			this.T=T;
			this.P=P;
			this.percent=percent;
		}
		
		@Override
		public int compareTo(Score o) {
			if(this.percent>o.percent)
				return 1;
			else if(this.percent<o.percent) {
				return -1;
			}
			else {
				if(this.T==o.T) {
					return o.P-this.P;
				}
				return this.T-o.T;
			}
		}
		
	}
	static int N;
	static int T=0,P=0;
	static Score[] score;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		score=new Score[N];
		double[] per=new double[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			score[i]=new Score(x,y);
			T+=x;
			P+=y;
		}
		
		Arrays.sort(score);
		int tsum=0,psum=0;
		for (int i = 1; i < N; i++) {
            tsum+=score[i-1].T;
			psum+=score[i-1].P;
			per[i]=(double)(T-tsum)/(P-psum);  //D별 백분율 빼기 완성
		}
		
		Score[] tot=new Score[N];
		for (int i = 0; i < N; i++) {
			tot[i]=new Score(score[i].T,score[i].P,-1*(double)(T-score[i].T)/(P-score[i].P));  //오름차순 정렬
		}
		Arrays.sort(tot);
		
		tsum=0;
		psum=0;
		double[] sum=new double[N];
		for (int i = 1; i < N; i++) {
            tsum+=tot[i-1].T;
			psum+=tot[i-1].P;
			sum[i]=(double)(T-tsum)/(P-psum); 
		}
		
		List<Integer> D=new ArrayList<>();
		for (int i = 1; i < N; i++) {
			if(per[i]<sum[i]) {
				D.add(i);
			}
		}
		
		System.out.println(D.size());
		for (int i = 0; i < D.size(); i++) {
			System.out.println(D.get(i));
		}
	}

}
