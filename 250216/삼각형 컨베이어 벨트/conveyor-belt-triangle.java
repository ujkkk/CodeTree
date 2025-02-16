import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();

        int [] nums = new int[3*N];

        for(int i=0; i<3; i++){
            for(int j=0; j<N; j++){
                nums[N*i + j] = sc.nextInt();
            }
        }
        
        // 돌리기
        for(int t=0;t<T; t++){
            int temp = nums[N*3-1];

            for(int i=N*3-1; i>0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }

        // 출력
        print(nums);
    }

    public static void print(int [] nums){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            for(int j=0; j<N; j++){
                sb.append(nums[i*N +j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}