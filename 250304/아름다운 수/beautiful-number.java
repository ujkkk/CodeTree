import java.util.Scanner;

/*
어려웠던 점 : count를 static 변수를 사용안하고 누적해서 넘겨주는 것
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = countMagicNums(0, new int[n], n);

        System.out.println(sum);
    }

    public static int countMagicNums(int depth, int [] nums, int N){
        if(depth == N){
            // 아름다운 수인지 체크
            return isMagicNum(nums)? 1 : 0;
        }

        int sum = 0;
        for(int i=1; i<=4; i++){
            nums[depth] = i;
            sum += countMagicNums(depth +1, nums, N);
        }
        return sum;
    }

    private static boolean isMagicNum(int [] nums){
        int size = nums.length;
        int idx = 0;


        while(idx < size){
            int cur = nums[idx];
            for(int i=idx; i<idx+cur; i++){
                if(i>= size || nums[i] != cur){
                    return false;
                }
            }
            idx += cur;
        }
        return true;
    }
}