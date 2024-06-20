package basic.input;

import java.util.Arrays;
import java.util.Scanner;

// Scanner : 편하다. 다소 무겁다.
public class ScannerTest {

	public static void main(String[] args) {
		// input : 1 2 3 4 5
		{
			Scanner sc = new Scanner(System.in); // 콘솔로부터 입력받을 때는 System.in 이라는 표준입력을 통해 받는다.
			int[] input = new int[5];
			
			for (int i = 0; i < input.length; i++) {
				input[i] = sc.nextInt();
			}
			
//			for (int n : input) System.out.println(n);
			
			System.out.println(Arrays.toString(input)); // Arrays.toString(배열) : 1차원 배열 요소를 보여준다.
			
//			sc.close();
		}
		
		
//		// input : 1 A 3 B 5
		{
			Scanner sc = new Scanner(System.in);
			char[] input = new char[5];
			
			for (int i = 0; i < input.length; i++) {
				input[i] = sc.next().charAt(0); // sc.next(): 문자열
			}
			
			System.out.println(Arrays.toString(input));
		}
		
		
		// input : XYZQU
		{
			Scanner sc = new Scanner(System.in);
			char[] input = sc.nextLine().toCharArray();
			
			System.out.println(Arrays.toString(input));
		}
		
		
		/*
		 * input:
		 * 6
		 * 1 2 3 4 5 1
		 */
		{
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[] input = new int[N];
			
			for (int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
			}
			
			System.out.println(Arrays.toString(input));
		}
		
/*
input:
5
XYZQU
 */
		{
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			sc.nextLine(); // 남아있는 빈 개행문자 처리!!
			System.out.println(N);
			
//			char[] input = new char[N]; // 낭비
			char[] input = sc.nextLine().toCharArray();
			
			// sc.nextLine(): 개행문자가 있으면 끝난다.
			
			System.out.println(Arrays.toString(input));
		}
		
	}
}
