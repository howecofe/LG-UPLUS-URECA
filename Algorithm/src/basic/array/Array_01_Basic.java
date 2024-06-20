package basic.array;

// 배열 관련 알고리즘 문제
public class Array_01_Basic {

	public static void main(String[] args) {
		// 문제 1. 빈도수 구하기
		
		// "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi"
		// 위 문자열 중 각 알파벳 문자의 사용 횟수 (빈도수)
		// a ~ z 까지 모든 알파벳의 사용 횟수를 출력하세요.
		
		// 변수 26개, 26가지의 경우 처리?? 어렵다.
		// 그럼 어떻게? a~z 알파벳 수만큼의 카운팅 배열 생성
		{
			int[] alphaCnt = new int[26]; // alphaCnt[0] : a 빈도수, alphaCnt[1] : b 빈도수, .....
			
			// 알파벳 사용 횟수 카운팅
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			int strLen = str.length();
			
			for (int i = 0; i < strLen; i++) {
				alphaCnt[str.charAt(i) - 'a']++; // char 연산은 int 로 자동 형변환
			}
			
			// 출력
			for (int i = 0; i < alphaCnt.length; i++) {
				System.out.println((char)(i + 'a') + " " + alphaCnt[i]);
			}
		}
		
		System.out.println("-----------------");
		
		// 문제 2. 
		// 배열의 맨 앞부터 각 3자리씩 일정한 규칙이 있다. 앞 * 중 = 뒤
		// 규칙에 위반되는 쌍이 몇 개인지 출력
		{
			
			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
			
			int wrongCnt = 0;
			int intLen = intArray.length - 2;
			
			for (int i = 0; i < intLen; i+= 3) {
				if (intArray[i] * intArray[i + 1] != intArray[i + 2]) wrongCnt++;
			}
			
			System.out.println(wrongCnt);
		}
		
		System.out.println("-----------------");
		
		// 문제 3.
		// 좌우 비대칭 문자가 있으면 출력, 전체 비대칭 문자가 몇 개인지 출력
		{
			String str = "XYZEBFFGQOVVPWGFFCEAYX";
			char[] chArr = str.toCharArray();
			
			int cnt = 0;
			int center = chArr.length / 2;
			
			for (int l = 0, r = chArr.length - 1; l < center; l++, r--) {
				if (chArr[l] != chArr[r]) {
					System.out.println(chArr[l] + " " + chArr[r]);
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}

}
