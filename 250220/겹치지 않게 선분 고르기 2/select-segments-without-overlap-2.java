import java.util.*;
import java.io.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int [][] dp;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> lines = new ArrayList();

        StringTokenizer st;
        int max = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            max = Math.max(end, max);

            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        dp = new int[max+1][2];
    
    
        for(Line line : lines){
            for(int i=line.start; i<=line.end; i++){
                for(int j=0; j<line.start; j++){
                    // 이전 줄의 끝점이 현재 줄의 start보다 작아야 함
                    if(dp[j][1] >= line.start){
                        continue;
                    }
                    if(dp[i][0] < dp[j][0] +1){
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] +1);
                        dp[i][1] = line
                }
            }
            //print();
        }

        int ans = 0;
        for(int i=0; i<=max; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        System.out.println(ans);


.end;
                    }
                    //dp[i][1] = Math.min(dp[i][1], dp[j][1]);
                }
            }
            //print();
        }

        int ans = 0;
        for(int i=0; i<=max; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        System.out.println(ans);
    }

    public static void print(){
        for(int i=0; i<10; i++){
            System.out.print(dp[i][0] +" ");
        }
        System.out.println();
        for(int i=0; i<10; i++){
            System.out.print(dp[i][1] +" ");
        }
        System.out.println();
    }
}

class Line implements Comparable<Line>{
    int start;
    int end;

    public Line(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Line o){
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}