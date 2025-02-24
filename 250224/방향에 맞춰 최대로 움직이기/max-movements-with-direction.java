import java.util.Scanner;
public class Main {
    static int ans = 0;
    static int N;
    static int [] dr = {-1, -1 ,0, 1, 1, 1, 0, -1};
    static int [] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int [][] num;
    static int [][] moveDir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please Write your code.
        select(0, r-1, c-1);

        System.out.println(ans);
    }

    public static void select(int depth, int r, int c){
        // 방문할 수 가 없으면 리턴
        boolean isChage = false;
        int curDir = moveDir[r][c];
        int curNum = num[r][c];

        for(int i=1; ; i++){
            int nr = r + dr[curDir-1]*i;
            int nc = c + dc[curDir-1]*i;

            if(!isRange(nr, nc)){
                break;
            }
            if(num[nr][nc] > curNum){
                isChage = true;
                select(depth+1, nr, nc);
            }
        }

        if(!isChage){
            ans = Math.max(ans, depth);
            return;
        }
    }

    public static boolean isRange(int r, int c){
        return (r >=0 && r<N && c>=0 && c<N);
    }
}