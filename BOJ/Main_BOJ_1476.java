import java.util.Scanner;

public class Main_BOJ_1476 {

	static int E,S,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		E=sc.nextInt();
		S=sc.nextInt();
		M=sc.nextInt();
		if(S==28) S=0;
		if(M==19) M=0;
		
		int index=0;
		int year=0;
		while(true) {
			year=15*index+E;
			if((year%28==S)&&(year%19==M)) {
				break;
			}
			index++;
		}
	
		System.out.println(year);
	}

}
