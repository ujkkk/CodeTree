import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int [][] map;

    public static void main(String[] args) throws IOException {
        input();
        int max = getMaxOfTwoPolygon();
        System.out.println(max);
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static int getMaxOfTwoPolygon(){
        boolean [][] check = new boolean[N][M];
        int max = -10000;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int rl =1; i+rl<=N; rl++){
                    for(int cl=1; j+cl<=M; cl++){
                        int sum1 = checkAndGetSum(i, j, rl, cl, check);
                        //System.out.println("sum1 : " + sum1);
                        int sum2 = getSumAnotherPolygon(check);
                        //System.out.println("sum2 : " + sum2);
                        max = Math.max(sum1 + sum2, max);
                        unCheck(i, j, rl, cl, check);
                    }
                }
            }
        }
        return max;
    }

    // r, c 지점에 두 번째 직사각형을 그렸을 떄의 최대값
    public static int getSumAnotherPolygon(boolean [][] isCheck){
        int sum = -10000;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int rl =1; i+rl<=N; rl++){
                    for(int cl=1 ;j+cl<=M; cl++){
                        if(isCheck[i][j])
                            continue;
                        sum = Math.max(sum, getSum(i, j, rl, cl, isCheck));
                    }
                }
            }
        }
        return sum;
    }

    // r, c 지점에 rlxcl 크기의 직사각형을 그렸을 때의 값
    public static int getSum(int r, int c, int rl, int cl, boolean [][] isCheck){
        int sum = 0;
        for(int i=0; i<rl ;i++){
            for(int j=0; j<cl; j++){
                if(r+i < 0 || r+i >=N || c+j < 0|| c+j >=M){
                    return -10000;
                }
                if(isCheck[r+i][c+j]){
                    return -10000;
                }
                sum += map[r+i][c+j];
            }
        }
        return sum;
    }
    

    public static int checkAndGetSum(int r, int c, int rl, int cl, boolean [][] isCheck){
        int sum = 0;
        
        for(int i=0; i<rl ; i++){
            for(int j=0; j<cl; j++){
                isCheck[r+i][c+j] = true;
                sum += map[r+i][c+j];
            }
        }
        return sum;
    }

    public static void unCheck(int r, int c, int rl, int cl, boolean [][] isCheck){
        for(int i=0; i <rl ; i++){
            for(int j=0; j<cl; j++){
                isCheck[r+i][c+j] = false;
            }
        }
    }
}