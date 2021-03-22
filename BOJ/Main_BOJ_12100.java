import java.util.Scanner;

public class Main_BOJ_12100 {

	static int N,tot;
	//static int[][] block;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int[][] block=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				block[i][j]=sc.nextInt();
			}
		}
		
		move(block,0);
		System.out.println(tot);
		
	}
	
	private static void move(int[][] arr,int cnt) {
		if(cnt==5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(tot<arr[i][j]) {
						tot=arr[i][j];
					}
				}
			}
			return;
		}
		
		int[][] temp=new int[N][N];
		//상
		init(temp,arr);
		for (int i = 0; i < N; i++) {
			int index=0;
			for (int j = 1; j < N; j++) {
				if(temp[j][i]==0) continue;
				if(temp[index][i]==temp[j][i]) {
					temp[index][i]*=2;
					index+=1; //한번의 이동에서 한번 합쳐지면 끝
					temp[j][i]=0;
				}
				else{ //두개가 다르면
					if(temp[index][i]==0) {  //제일 앞이 비었을 때
						temp[index][i]=temp[j][i];
					}
					else {
						temp[index+1][i]=temp[j][i];
						index+=1;
					}
					
					if(index!=j) {
						temp[j][i]=0;
					}
				}
				
			}
		}
		move(temp,cnt+1);
		
		//하
		init(temp,arr);
		for (int i = 0; i < N; i++) {
			int index=N-1;
			for (int j = N-2; j >= 0; j--) {
				if(temp[j][i]==0) continue;
				if(temp[index][i]==temp[j][i]) {
					temp[index][i]*=2;
					index-=1;
					temp[j][i]=0;
				}
				else{ //두개가 다르면
					if(temp[index][i]==0) {  //제일 앞이 비었을 때
						temp[index][i]=temp[j][i];
					}
					else {
						temp[index-1][i]=temp[j][i];
						index-=1;
					}
					
					if(index!=j) {
						temp[j][i]=0;
					}
				}
				
			}
		}
		move(temp,cnt+1);
		
		//좌
		init(temp,arr);
		for (int i = 0; i < N; i++) {
			int index=0;
			for (int j = 1; j < N; j++) {
				if(temp[i][j]==0) continue;
				if(temp[i][index]==temp[i][j]) {
					temp[i][index]*=2;
					index+=1;
					temp[i][j]=0;
				}
				else{ //두개가 다르면
					if(temp[i][index]==0) {  //제일 앞이 비었을 때
						temp[i][index]=temp[i][j];
					}
					else {
						temp[i][index+1]=temp[i][j];
						index+=1;
					}
					
					if(index!=j) {
						temp[i][j]=0;
					}
				}
				
			}
		}
		move(temp,cnt+1);
		
		
		//우
		init(temp,arr);
		for (int i = 0; i < N; i++) {
			int index=N-1;
			for (int j = N-2; j >= 0; j--) {
				if(temp[i][j]==0) continue;
				if(temp[i][index]==temp[i][j]) {
					temp[i][index]*=2;
					index-=1;
					temp[i][j]=0;
				}
				else{ //두개가 다르면
					if(temp[i][index]==0) {  //제일 앞이 비었을 때
						temp[i][index]=temp[i][j];
					}
					else {
						temp[i][index-1]=temp[i][j];
						index-=1;
					}
					
					if(index!=j) {
						temp[i][j]=0;
					}
				}
				
			}
		}
		move(temp,cnt+1);

	}
	
	static void init(int[][] a1,int[][] a2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a1[i][j]=a2[i][j];
			}
		}
	}

}
