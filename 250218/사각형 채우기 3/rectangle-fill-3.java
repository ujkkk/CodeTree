import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] dp = new int[N+10];
        dp[1] = 2;
        dp[2] = 7;

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1]*2 + dp[i-2]*3 +dp[i-2])%1_000_000_007;
        }

        System.out.println(dp[N]);
    }
}