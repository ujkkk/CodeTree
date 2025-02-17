import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int [][] map;
    static int [] bomb = new int[2];
    
    public static void main(String[] args) throws IOException {
        input();
        solution(bomb[0]-1, bomb[1]-1);
        print();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        bomb[0] = Integer.parseInt(st.nextToken());
        bomb[1] = Integer.parseInt(st.nextToken());

    }

    public static void solution(int r, int c){
        int n = map[r][c];
        bomb(r, c, n);
        // 중력 작용
        gravity();
    }

    public static void bomb(int r, int c, int n){
        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        map[r][c] = 0;
        for(int i=0; i<4; i++){
            for(int j=1; j<n; j++){
                int nr = r + dr[i]*j;
                int nc = c + dc[i]*j;

                if(!isCheck(nr, nc))
                    continue;
                
                map[nr][nc] = 0;
            }
        }
    }

     public static void gravity(){
        int[][] temp = new int[N][N];

        for(int c=0; c<N; c++){
            int tempCount = N-1;
            for(int r=N-1; r>=0; r--){
                if(map[r][c] == 0)
                    continue;
                
                temp[tempCount--][c] = map[r][c];
            }
        }

        // 복사하기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = temp[i][j];
            }
        }
    }
    
    public static boolean isCheck(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

}