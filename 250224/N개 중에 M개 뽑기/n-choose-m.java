import java.util.Scanner;

public class Main {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        select(1, new int[m], 0);
        System.out.println(sb.toString());
    }

    public static void select(int depth, int [] nums, int cnt){
        if(n +1 == depth){
            if(m == cnt){
                print(nums);
            }
            return;
        }

        if(cnt < m){
            nums[cnt] = depth;
            select(depth +1, nums, cnt+1);
        }
        select(depth+1, nums, cnt);
    }

    public static void print(int [] nums){
        for(int i : nums){
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}