import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, Q;   
    static int [][] map;

    public static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 행렬의 크기
        M = Integer.parseInt(st.nextToken());  // 행렬의 크기
        Q = Integer.parseInt(st.nextToken());  // 바람의 수

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void firstWind(int r, String d){
        //System.out.println("firstWidn: " + r + ": " + d);
        push(r, d);
        String nextD = d.equals("L")? "R" : "L";
        // 전파
        for(int i=r-1; i>=0; i--){
            if(isSame(r, i)){
                // 위로 향하는 전파시작
                topSpread(i, nextD);
            }
            break;
        }

        for(int i=r+1; i<N; i++){
            if(isSame(r, i)){
                // 아래로 향하는 전파시작
                bottomSpread(i, nextD);
            }
            break;
        }
    }

    public static void topSpread(int r, String d){
        push(r, d);

        for(int i=r-1; i>=0; i--){
            if(isSame(r, i)){
                // 위로 향하는 전파시작
                topSpread(i, d.equals("L")? "R" : "L");
                break;
            }
        }
    }

    public static void bottomSpread(int r, String d){
        push(r, d);

         for(int i=r+1; i<N; i++){
            if(isSame(r, i)){
                // 아래로 향하는 전파시작
                bottomSpread(i, d.equals("L")? "R" : "L");
                break;
            }
        }
    }

    public static void push(int r, String d){
        // 밀어내기
        if(d.equals("L")){
            int temp = map[r][M-1];
            for(int i=M-1; i>0; i--){
                map[r][i] = map[r][i-1];
            }
            map[r][0] = temp;
        }
        else{
            int temp = map[r][0];
            for(int i=0; i<M-1; i++){
                map[r][i] = map[r][i+1];
            }
            map[r][M-1] = temp;
        }
    }

    public static boolean isSame(int r1, int r2){
        for(int i=0; i<M; i++){
            if(map[r1][i] == map[r2][i]){
                return true;
            }
        }
        return false;
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();

        for(int q = 0; q<Q; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            firstWind(r-1, d);
        }

        print();
    }

}