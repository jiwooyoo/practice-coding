import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_BOJ_2525 {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A, B;
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		//br.read();
		int C=Integer.parseInt(br.readLine());
		
		int minute=B+C;
		int hour=0;
		
		while(true) {
			if(minute<60) break;
			hour++;
			minute-=60;
		}
		
		hour=hour+A;
		if(hour>23) hour-=24;
	//	System.out.println(A+" "+B+" "+C);
		System.out.println(hour+" "+minute);
	}

}
