import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];
        long [][] dp = new long[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = map[0][0];
        // 최상단 행 초기화
        for(int i=1; i<N; i++){
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        // 최좌측 열 초기화
        for(int i=1; i<N; i++){
            dp[i][0] = dp[i-1][0] + map[i][0];
        }


        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]) + map[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}