import java.util.Scanner;

public class Main_BOJ_2477 {

	static int K;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		K=sc.nextInt();
		
		int[] arr=new int[6];
		int dir,num;
		int max_w=0,max_h=0;
		int in_w=0,in_h=0;
		for (int i = 0; i < 6; i++) {
			dir=sc.nextInt();
			num=sc.nextInt();
			
			arr[i]=num;
			if(dir<=2) {  //가로
				if(max_w<num) {
					max_w=num;
					in_w=i;
				}
			}
			else {  
				if(max_h<num) {
					max_h=num;
					in_h=i;
				}
			}
		}
		
		int width=0,height=0;
		if(in_w==0) {
			width=Math.abs(arr[5]-arr[in_w+1]);
		}
		else if(in_w==5) {
			width=Math.abs(arr[in_w-1]-arr[0]);
		}
		else {
			width=Math.abs(arr[in_w-1]-arr[in_w+1]);
		}
			
		if(in_h==0) {
			height=Math.abs(arr[5]-arr[in_h+1]);
		}
		else if(in_h==5) {
			height=Math.abs(arr[in_h-1]-arr[0]);
		}
		else {
			height=Math.abs(arr[in_h-1]-arr[in_h+1]);
		}
		
		int ans=max_w*max_h-width*height;
		System.out.println(ans*K);
	}

}
