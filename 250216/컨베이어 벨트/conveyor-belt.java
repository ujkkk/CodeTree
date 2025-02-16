import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void rotate(int [][] map, int N){
        int temp = map[0][N-1];
        int temp2 = map[1][N-1];
        // ->
        for(int i=N-1; i>0; i--){
            map[0][i] = map[0][i-1];
            map[1][i] = map[1][i-1];
        }
        map[1][0] = temp;
        map[0][0] = temp2;
       
    }

    public static void print(int [][] map)  throws IOException{
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int [][] map = new int[2][N];
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0; t<T; t++){
            rotate(map, N);
        }
        print(map);
    }
}