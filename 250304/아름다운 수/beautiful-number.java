import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = magicNum(0, new int[n], n);

        System.out.println(sum);
    }

    public static int magicNum(int depth, int [] nums, int N){
        if(depth == N){
            // 아름다운 수인지 체크
            if(isMagicNum(nums)){
                // System.out.println("매직넘");
                return 1;
            }
            return 0;
        }

        int sum = 0;
        for(int i=1; i<=4; i++){
            nums[depth] = i;
            sum += magicNum(depth +1, nums, N);
        }
        return sum;
    }

    private static boolean isMagicNum(int [] nums){
        int size = nums.length;
        int idx = 0;

        // for(int n : nums){
        //     System.out.print(n +" ");
        // }
        // System.out.println();

        while(idx < size){
            int cur = nums[idx];
            for(int i=idx; i<idx+cur; i++){
                if(i>= size){
                    // System.out.println("사이즈 초과");
                    return false;
                    
                }
                if(nums[i] != cur){
                    // System.out.println(i +"번 째에서 같지 않음");
                    return false;
                }
            }
            idx += cur;
        }
        return true;
    }
}