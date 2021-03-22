import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1759 {
	static int L,C;
	static char[] ch,res;
	static boolean[] v;
	static String s1="aeiou";
	static StringBuffer sb=new StringBuffer();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		L=sc.nextInt();
		C=sc.nextInt();
		ch=new char[C];
		v=new boolean[C];
		res=new char[L];
		
		for (int i = 0; i < C; i++) {
			ch[i]=sc.next().charAt(0);
		}
		
		Arrays.sort(ch);
		
		nextP(0,0);
		System.out.println(sb);
	}
	
	private static void nextP(int cnt,int start) {
		if(cnt==L) {
			int n1=0,n2=0;
			for (int i = 0; i < L; i++) {
				if(s1.indexOf(res[i])==-1) {
					n2++;
				}
				else {
					n1++;
				}
			}
			
			if(n1>=1 && n2>=2) {
				for (int i = 0; i < L; i++) {
					sb.append(res[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
		//	if(v[i]) continue;
		//	v[i]=true;
			res[cnt]=ch[i];
			nextP(cnt+1,i+1);
			//v[i]=false;
		}
	}

}
