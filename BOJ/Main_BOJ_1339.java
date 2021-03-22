import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main_BOJ_1339 {

	static class Node{
		int cnt;
		int alphabet;
		Node(int cnt,int alp){
			this.cnt=cnt;
			this.alphabet=alp;
		}
	}
	
	static int[] p;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] alp=new int[26];
		String[] st=new String[N];
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			st[i]=s;
			for (int j = 0; j < s.length(); j++) {
				alp[s.charAt(j)-'A']++;
			}
		}
		
		int tot=0;
		for (int i = 0; i < 26; i++) {
			if(alp[i]!=0) tot++;
		}
		
		Node[] node=new Node[tot];
		int index=0;
		for (int i = 0; i < 26; i++) {
			if(alp[i]==0) continue;
			node[index++]=new Node(alp[i],i);
		}
		
		p=new int[tot];
		for (int i = 0; i < tot; i++) {
			p[i]=10-tot+i;
		}
		
		long res=0;
		do {
			long sum=0;
			for (int i = 0; i < N; i++) {
				long num=0;
				int len=st[i].length();
				for (int j = 0; j < len; j++) {
					for (int k = 0; k < tot; k++) {
						if(node[k].alphabet==(st[i].charAt(j)-'A')){
							num*=10;
							num+=p[k];
							//System.out.println(sum);
							break;
						}
					}
				}
				sum+=num;
			}
			res=Math.max(res, sum);
		}while(np(p.length-1));
		System.out.println(res);
	}
	
	private static boolean np(int size) {
		int i=size;
		while(i>0&&p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[j];
		p[j]=p[i-1];
		p[i-1]=temp;
		int k=size;
		while(i<k) {
			temp=p[k];
			p[k]=p[i];
			p[i]=temp;
			k--;
			i++;
		}
		return true;
	}
}
