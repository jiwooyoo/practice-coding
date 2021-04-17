import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Main_BOJ_1406 {

	static int N,M;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine();
		N=s.length();
		M=Integer.parseInt(br.readLine());
		
		List<Character> list=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(s.charAt(i));
		}
		
		ListIterator<Character> iter=list.listIterator();
		while(iter.hasNext()) {
			iter.next();  // 초기 위치인 맨 뒤로 이동 시켜줌  
		}
		
		Queue<char[]> q=new LinkedList<>();
		for (int i = 0; i < M; i++) {
			char[] temp=br.readLine().replace(" ", "").toCharArray();
			q.offer(temp);
		}
		
		int curser=N;  // 커서 초기 위치는 문자열의 맨 뒤 
		while(!q.isEmpty()) {
			char[] temp=q.poll();
			char command=temp[0];
			if(command=='L') {
				if(iter.hasPrevious()) iter.previous();  //앞에가 존재하면 앞으로 이터레이터 이동  
			} else if(command=='D') {   // 맨 뒤면 무시 
				if(iter.hasNext()) iter.next();   //뒤에 존재하면 이동 
			} else if(command=='B') {
				if(iter.hasPrevious()) {
					iter.previous();   // iterater는 마지막으로 리턴된 객체를 지워준다. 왼쪽인 previous를  
					iter.remove();    // 앞에서 호출했으니 그것을 지워주는 것! 
				}
			} else {
				char ch=temp[1];
				iter.add(ch);  // 삽입 위치 다음으로 iter 이동 됨 
			}
			
		}
		
		for (Character c:list) {
			bw.write(c);
		}
		
		bw.flush();
		bw.close();
	}

}
