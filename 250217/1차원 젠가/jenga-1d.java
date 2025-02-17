import java.util.*;

public class Main {
    public static int [] nums;
    public static int N;

    public static void push(int s, int e){
        // 제거
        for(int i=s; i<=e; i++){
            nums[i] = 0;
        }

        // 복사
        int [] temp = new int[N];
        int tempCount = 0;
        for(int i=0; i<N ;i++){
            if(nums[i] == 0){
                continue;
            }

            temp[tempCount++] = nums[i];
        }

        // 복구
        for(int i=0; i<N; i++){
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        for(int q =0; q<2; q++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            push(s-1, e-1);
        }

        StringBuilder sb = new StringBuilder();
        int size = 0;
        for(int i=0; i<N; i++){
            if(nums[i] == 0){
                continue;
            }
            sb.append(nums[i]).append("\n");
            size++;
        }

        System.out.println(size);
        System.out.println(sb.toString());
    }
}