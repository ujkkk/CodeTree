import java.util.*;

public class Main {

    public static int N, K;
    public static void select(int depth, int [] select, StringBuilder sb){
        if(depth == K){
            for(int n : select){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            select[depth] = i;
            select(depth +1, select, sb);
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // 중복을 허용해서 뽑기
        int [] select = new int[K];
        StringBuilder sb = new StringBuilder();
        select(0, select, sb);

        System.out.println(sb.toString());
    }
}