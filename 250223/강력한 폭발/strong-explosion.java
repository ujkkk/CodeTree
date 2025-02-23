import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int [][] check;
    public static ArrayList<Point> bombs;
    static int count = 0;

    public static int ans = 0;

    public static int getPoint(int [][] check){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(check[i][j] > 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void checkBombs(int [][] check, int r, int c, int kind){
        //System.out.println(String.format("%d %d, %d 종류 체크", r, c, kind));
        count++;
        int [][] dr = { {-1, -2, 1, 2}, {-1, 0, 1, 0}, {-1, -1, 1, 1} };
        int [][] dc = { {0, 0, 0, 0,}, {0, 1, 0, -1}, {-1, 1, 1, -1}};

        check[r][c]++;
        for(int i=0; i<dr[kind].length; i++){
            int nr = r + dr[kind][i];
            int nc = c + dc[kind][i];

            if(nr <0 || nr >=N || nc <0 || nc >=N)
                continue;
            
            check[nr][nc]++;
        }
        return;
    }

    public static void removeBombs(int [][] check, int r, int c, int kind){
        //System.out.println(String.format("%d %d, %d 종류 삭제", r, c, kind));
        int [][] dr = { {-1, -2, 1, 2}, {-1, 0, 1, 0}, {-1, -1, 1, 1} };
        int [][] dc = { {0, 0, 0, 0,}, {0, 1, 0, -1}, {-1, 1, 1, -1}};

        check[r][c]--;
    
        for(int i=0; i<dr[kind].length; i++){
            int nr = r + dr[kind][i];
            int nc = c + dc[kind][i];

            if(nr <0 || nr >=N || nc <0 || nc >=N)
                continue;
            
            check[nr][nc]--;
        
        }
        return;
    }


    public static void select(int depth, int [][] check){
        if(depth == bombs.size()){
            int count = getPoint(check);
            ans = Math.max(count, ans);
            return;
        }

        for(int i=depth; i<depth+1; i++){
            int r = bombs.get(i).r;
            int c = bombs.get(i).c;

            for(int j=0; j<3; j++){
                checkBombs(check, r, c, j);
                select(depth +1, check);
                removeBombs(check, r, c, j);
            }
        }
    }

    public static void print(int [][] check){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(check[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        check = new int[N][N];
        bombs = new ArrayList();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1){
                    bombs.add(new Point(i, j));
                }
            }
        }

        select(0, check);
        System.out.println(ans);
        //System.out.println("count: " + count);

    }
}

class Point{
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}