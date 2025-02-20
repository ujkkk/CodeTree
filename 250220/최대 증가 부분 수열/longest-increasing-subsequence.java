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

        dp[0] = 1;
        // 증가하는 부분 수열
        // 자기보다 작은 것 중 최댓 값
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                // 증가하는 수열일 때만
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] +1, dp[i]);
                }
                
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}