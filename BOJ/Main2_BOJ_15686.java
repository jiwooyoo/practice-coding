import java.util.ArrayList;
import java.util.Scanner;

public class Main2_BOJ_15686 {

	static int N,M;
	static int[][] arr;
	static int[] p;
	static class Location {
		int r;
		int c;
		public Location(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Location> chicken=new ArrayList<>();
		ArrayList<Location> house=new ArrayList<>();
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1) {
					house.add(new Location(i,j));
				}
				if(arr[i][j]==2) {
					chicken.add(new Location(i,j));
				}
			}
		}
		
		p=new int[chicken.size()];
		for (int i = 1; i <= M; i++) {
			p[chicken.size()-i]=1;
		}
		
		int tot=Integer.MAX_VALUE;
		do {
			int sum=0;
			for (int i = 0; i < house.size(); i++) {
				int r=house.get(i).r;
				int c=house.get(i).c;
				int min=Integer.MAX_VALUE;
				for (int j = 0; j < p.length; j++) {
					if(p[j]==1) {
						int dis=Math.abs(r-chicken.get(j).r)+Math.abs(c-chicken.get(j).c);
						if(min>dis) min=dis;
					}
				}
				sum+=min;
			}
			if(sum<tot) tot=sum;
		}while(np(p.length-1));
		
		System.out.println(tot);
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
			i++;
			k--;
		}
		return true;
	}

}
