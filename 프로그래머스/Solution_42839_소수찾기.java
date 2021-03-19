import java.util.ArrayList;
import java.util.Arrays;

public class Solution_42839_소수찾기 {
	
	static boolean[] visit;
	static int len;
	static boolean[] arr;
	static int[] p;
	static ArrayList<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		String numbers="17";
		len=numbers.length();
		visit=new boolean[len];
		p=new int[len];
		for (int i = 0; i < len; i++) {
			p[i]=numbers.charAt(i)-'0';
		}
		Arrays.sort(p);
		int max=10000001;
		arr=new boolean[max];
		arr[1]=true;
		arr[0]=true;
		for (int i = 2; i < max; i++) {
			int j=2;
			while(j*i<max) {
				if(!arr[j*i]) {
					arr[j*i]=true;
				}
				j++;
			}
		}
		
		do {
			String ss="";
			for (int i = 0; i < len; i++) {
				ss+=p[i];
			}
			subset(ss,0);
		}while(np(p.length-1));
		

		System.out.println(list.size());
	}

	
	private static boolean np(int size) {
		int i=size;
		while(i>0&&p[i-1]>=p[i]) i--;
		if(i==0) return false;
		
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		
		return true;
	}


	public static void subset(String s,int cnt) {
		if(cnt==len) {
			String sb="";
			for (int i = 0; i < len; i++) {
				if(visit[i]) {
					sb+=s.charAt(i);
				}
			}
			if(sb.isEmpty()) return;
			int n=Integer.parseInt(sb);
			if(!arr[n]) {
				if(list.isEmpty()||!list.contains(n)) {
					list.add(n);
				}
			}
			return;
		}
		
		visit[cnt]=true;
		subset(s,cnt+1);
		
		visit[cnt]=false;
		subset(s,cnt+1);
	}
}
