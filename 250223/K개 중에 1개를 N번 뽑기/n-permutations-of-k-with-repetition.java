import java.util.*;

public class Main {

    public static int N, K;
    public static void select(int depth, ArrayList<Integer> select, StringBuilder sb){
        if(depth == K){
            for(int n : select){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            select.add(i);
            select(depth +1, select, sb);
            select.remove(select.size() -1);
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // 중복을 허용해서 뽑기
        StringBuilder sb = new StringBuilder();
        select(0, new ArrayList<Integer>(), sb);

        System.out.println(sb.toString());
    }
}