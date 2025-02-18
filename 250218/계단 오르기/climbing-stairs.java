import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 점화식 dp[i] = dp[i-2] + dp[i-3]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] dp = new int[N+5];
        dp[2] = dp[3] = 1;
        dp[4] = 2;
        for(int i=5; i<=N; i++){
            dp[i] = (dp[i-2] + dp[i-3])%10007;
        }

        System.out.println(dp[N]);
    }
}