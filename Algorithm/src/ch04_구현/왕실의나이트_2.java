package ch04_구현;

import java.util.Scanner;

public class 왕실의나이트_2 {
	
	static int y, x, result;
    static int[] dy = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dx = {-2, 2, -2, 2, -1, 1, -1, 1};
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        y = inputData.charAt(1) - '0';
        x = inputData.charAt(0) - 'a' + 1;
        
        if (y > 2 && y < 7 && x > 2 && x < 7) { // 안전영역
        	System.out.println(8);
        	return;
       }

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        for (int d = 0; d < 8; d++) {
            // 이동하고자 하는 위치 확인
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (ny < 1 || nx < 1 || ny > 8 || nx > 8) continue;
            
            // 해당 위치로 이동이 가능하다면 카운트 증가
            result++;
        }

        System.out.println(result);
    }
}

/*
a1

2
*/
