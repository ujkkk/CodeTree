import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] nums = new int[N];
        int [] dp = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        // 처음 칸에서 점프할 수 있는 칸
        for(int i=0; i<=nums[0]; i++){
            dp[i] = 1;
        }

        // 최대 점프 횟수
        for(int i=1; i<N; i++){
            // 처음 시작 위치에서 도달할 수 없을 시
            if(dp[i] == 0){
                continue;
            }
            for(int j=i+1; j<=i+nums[i]; j++){
                // 범위를 벗어나는 경우 패스
                if(j >= N ){
                    continue;
                }
                dp[j] = Math.max(dp[j], dp[i] +1);
            }
        }

        int ans = 0 ;
        for(int i=0; i<N; i++){
            //System.out.print(dp[i] +" ");
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}