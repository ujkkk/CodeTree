import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // O(n^2)/2 최대 35천만
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                dp[i][j] = -1;

        dp[0][0] = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // (i, j)로 올수 있는 칸은 (0~i-1, 0~j-1)킨 들
                for(int a=0; a<=i-1; a++){
                    for(int b=0; b<=j-1; b++){
                        // 첫 번째 칸으로 도달 못할 시
                        if(map[a][b] == -1){
                            continue;
                        }
                        if(map[i][j] <= map[a][b]){
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[a][b] +1);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                ans = Math.max(ans, dp[i][j]);
                //System.out.print(dp[i][j] +" ");
            }
            //System.out.println();
        }
        System.out.println(ans);   
    }
}