import java.util.Scanner;

public class Main {

    static int K, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        
        int [] nums = new int[N];
        StringBuilder sb = new StringBuilder();
        select(0, nums, sb);

        System.out.println(sb.toString());
        
    }

    public static void select(int depth, int [] nums, StringBuilder sb){
        if(depth == N){
            for(int n : nums){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=K; i++){
            nums[depth] = i;
            // 연속하여 같은 숫자가 3번 이상 나올 때
            if(depth >= 2 && nums[depth-2] == nums[depth-1] && nums[depth-1] == nums[depth]){
                continue;
            }
            select(depth+1, nums, sb);
        }
    }
}