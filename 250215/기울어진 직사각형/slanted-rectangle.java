import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int [][] map;

    public static boolean isBound(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static int getSumOfPolygon(int r, int c, int rl ,int cl){
        int sum = 0;
        int [] dr = {-1, -1, 1, 1};
        int [] dc = {1, -1 ,-1, 1};
        int [] moveNum = {rl, cl, rl, cl};
        int nr = r;
        int nc = c;

        for(int d=0; d<4; d++){
            for(int j=0; j<moveNum[d]; j++){
                nr += dr[d];
                nc += dc[d];

                if(!isBound(nr, nc)){
                    return -1;
                }
                sum += map[nr][nc];
            }
        }
        return sum;
    }

    public static int getMaxOfPoint(int r, int c){
        int max = 0;
        // 한 점을 시작점으로 그릴 수 있는 기울어진 직사각형을 그려봄
        for(int rl=1; rl<N; rl++){
            for(int cl=1; cl<N; cl++){
                int sum = getSumOfPolygon(r, c, rl, cl);
                if(sum == -1){
                    if(cl==1){
                        return max;
                    }
                    break;
                }
                max = Math.max(sum, max);
            }
        }
        return max;

    }

    public static int getMaxSum(){
        int max = 0;
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                max = Math.max(max, getMaxOfPoint(i, j));
            }
        }
        return max;
    }

    public static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException{
       
        input();
        int max = getMaxSum();
        //int max = getSumOfPolygon(4, 1, 3, 1);
        System.out.println(max);
    }
}