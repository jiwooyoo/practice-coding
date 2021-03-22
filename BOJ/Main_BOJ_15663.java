import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_15663 {
	static int N,M;
	static int[] num,arr;
	static boolean[] v;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		num=new int[M];
		v=new boolean[N];
		arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		nPr(0);
		System.out.println(sb);
	}

	private static void nPr(int cnt) {
		List<Integer> list=new ArrayList<>();
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			int sum=0;
			for (int j = 0; j < list.size(); j++) {
				if(arr[i]==list.get(j)) {
					sum++;
				}
			}
			
			if(sum==0) {
				v[i]=true;
				num[cnt]=arr[i];
				list.add(arr[i]);
				nPr(cnt+1);
				v[i]=false;
			}
			
		}
	}

}
