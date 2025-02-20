import java.util.*;
import java.io.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int [] dp;

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

        dp = new int[N+1];
        for(int i=0; i<N; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){
                int start = lines.get(j).start;
                int end = lines.get(j).end;

                if(end < lines.get(i).start){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, dp[i]);
        }
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
        return this.start - o.start;
    }
}