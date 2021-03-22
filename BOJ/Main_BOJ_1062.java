import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_1062 {

	static int N,K;
	static String[] word;
	static boolean[] check;
	static int res;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		word=new String[N];
		int[] alp=new int[26];
		check=new boolean[26];
		
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		else if(K==26){
			System.out.println(N);
			return;
		}
		else {
			for (int i = 0; i < N; i++) {
				String str=sc.next();
				word[i]=str.substring(4, str.length()-4);
			}
			K-=5;
			
			char[] ch= {'a','n','t','i','c'};
			for (int i = 0; i < 5; i++) {
				check[ch[i]-'a']=true;
			}
			
			dfs(0,0);
			System.out.println(res);
		}
	
		
	}

	private static void dfs(int start, int cnt) {
		if(cnt==K) {
			int tot=0;
			for (int i = 0; i < N; i++) {
				boolean flag=true;
				for (int j = 0; j < word[i].length(); j++) {
					if(!check[word[i].charAt(j)-'a']) {
						flag=false;
						break;
					}
				}
				if(flag) tot++;
			}
			
			res=Math.max(res, tot);
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if(check[i]) continue;
			check[i]=true;
			dfs(i+1,cnt+1);
			check[i]=false;
		}
	}

}
