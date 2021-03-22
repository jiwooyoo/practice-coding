import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_15666 {
	static int N,M;
	static int[] arr,num;
	static StringBuffer sb=new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N];
		num=new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		nCr(0,0);
		System.out.println(sb);
	}

	private static void nCr(int cnt, int start) {		
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		List<Integer> list=new ArrayList<>();
		for (int i = start; i < N; i++) {
			int sum=0;
			for (int j = 0; j < list.size(); j++) {
				if(arr[i]==list.get(j)) sum++;
			}
			
			if(sum==0) {
				num[cnt]=arr[i];
				list.add(arr[i]);
				nCr(cnt+1,i);
			}
			
		}
	}

}
