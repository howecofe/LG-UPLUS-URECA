package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_빵집_3109 {
	
	static int R, C, ans;
	static char[][] map;
    
    // y 만 고려. x 는 항상 +1
    static int[] dy = {-1, 0, 1}; // 우선 순위: 우상, 우, 우하
    // visit ? 사용 X
    // 이전에 어떤 좌표를 지났으면 다음 시도(다음 파이프 연결)할 때 그 좌표는 이전에 성공하던 실패하던 갈 수가 없다.
    // why?
    // 좌표를 따라가서 성공 <= 이미 그 자리에 파이프가 놓여져 있다. 
    // 좌표를 따라가서 실패 <= 그 자리에 갈 필요가 없다.
    // 방문하면 'x' 표시
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][];
        
        for (int i = 0; i < R; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        // 풀이
        // 맨 위부터 맨 아래행으로 내려오면서 연결 시도
        for (int i = 0; i < R; i++) {
        	if (dfs(i, 0)) ans++; // 열은 항상 가장 왼쪽부터 (첫번째 열)
        }
        
        // 출력
        bw.write(ans + "");

        br.close();
        bw.flush();
        bw.close();

	}
	
	static boolean dfs(int y, int x) {
		int nx = x + 1; // 다음 움직임은 x 는 무조건 1 증가 (왼쪽)
		if (nx == C - 1) return true;
		
		// for문 안에서 3 방향 중 우선순위로 탐색하되, 먼저 성공하면 나머지 탐색은 진행 X
		for (int d = 0; d < 3; d++) {
			
			int ny = y + dy[d];
			if (ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
			
			// 갈 수 있는 곳이면
			map[ny][nx] = 'x'; // 일종의 visit 체크
			
			if (dfs(ny, nx)) return true; // 우선 성공하면 for문 끝나도록 여기서 끝내줘야 한다!
		}
		
		return false;
	}

}
