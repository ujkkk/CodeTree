import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];
        int [][] dp = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            dp[0][i] = map[0][i];
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<N; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + map[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j] + map[i][j],
                            dp[i][j-1] + map[i][j]);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(dp[N-1][i], ans);
        }
        System.out.println(ans);
    }
}