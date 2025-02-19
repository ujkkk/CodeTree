import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long [][] dp;
    static int [][] map;

    public static void getMax(int r, int c, int d){
        //System.out.println(String.format("[%d, %d], depth : %d, 값:%d", r, c, d, dp[r][c]));

        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(!isRange(nr, nc)){
                continue;
            }
            // 지금 정수가 다음 정수보다 크거나 같을 때 패스
            if(map[r][c] >= map[nr][nc]){
                continue;
            }

            // 갱신될 수 있을 때 다시 갱신
            if(dp[nr][nc] < dp[r][c] + 1){
                dp[nr][nc] = dp[r][c] +1;
                getMax(nr, nc, d+1);
            }
        }
    }

    public static boolean isRange(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new long[N][N];
        map = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dp[i][j] == 0)
                    getMax(i, j, 0);
            }
        }

        long ans =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans +1);
    }
}