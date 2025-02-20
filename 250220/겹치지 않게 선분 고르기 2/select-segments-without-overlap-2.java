import java.util.*;
import java.io.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> lines = new ArrayList();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        int [][] dp = new int[1001][2];
    
        for(Line line : lines){
            for(int i=0; i<line.start; i++){
                // 이전 줄의 끝점이 현재 줄의 start보다 작아야 함
                if(dp[i][1] >= line.start){
                    continue;
                }
                for(int j=line.start; j<=line.end; j++){
                    if(dp[j][0] < dp[i][0] +1){
                        dp[j][0] = Math.max(dp[j][0], dp[i][0] +1);
                        dp[j][1] = line.end;
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<100; i++){
            //System.out.print(dp[i][0] +" ");
            ans = Math.max(ans, dp[i][0]);
        }
        //System.out.println();
        System.out.println(ans);
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