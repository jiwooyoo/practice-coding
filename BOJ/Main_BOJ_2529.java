import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BOJ_2529 {
	static int k;
	static char[] oper;
	static int[] p,res,res2;
	static boolean[] v;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
		oper=new char[k];
		v=new boolean[10];
		p=new int[k+1];
		res=new int[k+1];
		res2=new int[k+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++)
	           oper[i] = st.nextToken().charAt(0);
		 
		perm(0);
		
		for (int i = 0; i < k+1; i++) {
			System.out.print(res2[i]);
		}
		System.out.println();
		for (int i = 0; i < k+1; i++) {
			System.out.print(res[i]);
		}
		System.out.println();
	}
	
	public static void perm(int cnt) {
		if(cnt==k+1) {
			check();
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(v[i]) continue;
			v[i]=true;
			p[cnt]=i;
			perm(cnt+1);
			v[i]=false;
		}
	}

	private static void check() {
		boolean flag=true;
		StringBuffer bf=new StringBuffer();
		for (int i = 0; i < k; i++) {
			if(oper[i]=='<') {
				if(p[i]>=p[i+1]) {
					flag=false;
					break;
				}
			}
			else {
				if(p[i]<=p[i+1]) {
					flag=false;
					break;
				}
			}
		}
		
		if(flag) {
			String s="";
			for (int i = 0; i < k+1; i++) {
				s+=p[i];
			}
			int n=Integer.parseInt(s);
			if(min>n) {
				for (int i = 0; i < k+1; i++) {
					res[i]=p[i];
				}
				min=n;
			}
			if(max<n) {
				for (int i = 0; i < k+1; i++) {
					res2[i]=p[i];
				}
				max=n;
			}
		}
	}
	
}
