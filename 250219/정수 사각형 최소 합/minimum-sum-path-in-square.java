import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int [][] a = new int[N][N];
        long [][] dp = new long[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][N-1] = a[0][N-1];
        // 최상단 행 초기화
        for(int i=N-2; i>=0; i--){
            dp[0][i] = dp[0][i+1] + a[0][i];
        }

        // 최우측 열 초기화
        for(int i=1; i<N; i++){
            dp[i][N-1] = dp[i-1][N-1] + a[i][N-1];
        }

        for(int i=1; i<N; i++){
            for(int j=N-2; j>=0; j--){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + a[i][j];
            }
        }

        System.out.println(dp[N-1][0]);
    }
}