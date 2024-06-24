package ch03_greedy;

import java.util.Scanner;

// 단순 반복 코드
// 연산 1: 1 빼기
// 연산 2: k 로 나누기 (우선순위)
public class _1이될때까지_2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0; // 연산 수행 횟수

        while (true) {
            // 우선 순위대로 n -> 1 로 변경
        	// 1 이 되면 종료
        	if (n == 1) break;
        	
        	// k 로 나눌 수 있으면 나눈다. (우선순위)
        	if (n % k == 0) {
        		n /= k;
        		result++;
        	} else {
        		// 여러개 연산 개수 처리
        		int target = (n / k) * k; // target : k 로 나누어 떨어지는 수
        		result += n - target;
        		n = target;
        	}
        	
        }

        System.out.println(result);
    }
}

/*
 25 5
 
 2
 --
 17 4
 
 3
 */


/*
 <그리디 알고리즘>
 - 모든 경우의 수를 다 따지 완전탐색(부르트포스) 대비
   꼭 필요한 (최선의) 선택을 통해서 답을 구하는 방식
 - 그리디의 전제 조건 : 지극히 당연한 논리, 수학적으로 증명된..
   막연한 추측은 절대 금물(500, 400, 100, 50, 10) 800
 - 문제가 그리디로 보이더라도 의심 또 의심
 - 완탐으로 풀 경우 (테케 건수가 무지 크다.. 등) 예상, 분명해 보이면 그리디 고려
   but 첫 번째 습관은 완탐으로 접근!
 - 타고난 수학적 직관력 또는 오랜 경험을 통한 판단
 - 그리디 문제는 특정 중요한 코테에 잘 나오지 않는다.
 
 - 그래프 알고리즘 <= 그리디 알고리즘 (수학적으로 증명됨)
 */