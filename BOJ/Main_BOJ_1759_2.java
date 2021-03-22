import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_BOJ_1759_2 {

	static int L,C;
	static ArrayList<Integer> mo=new ArrayList<>();
	static ArrayList<Integer> ja=new ArrayList<>();
	public static void main(String[] args) {
		String checkM="aeiou";
		Scanner sc=new Scanner(System.in);
		L=sc.nextInt();
		C=sc.nextInt();
		
		for (int i = 0; i < C; i++) {
			char c=sc.next().charAt(0);
			if(checkM.indexOf(c)!=-1) {
				mo.add(c-'0');
			}
			else {
				ja.add(c-'0');
			}
		}
		
		Collections.sort(mo);
		Collections.sort(ja);
		
		
	}
	
	public static void comb(int cnt,int start,int len) {
		for (int i = 0; i < len; i++) {
	
		}
	}
}
